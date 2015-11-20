/*
 * ******************************************************************************
 *   Copyright 2014-2015 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ****************************************************************************
 */

package com.spectralogic.ds3client.commands;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.spectralogic.ds3client.models.Checksum;
import com.spectralogic.ds3client.models.Error;
import com.spectralogic.ds3client.networking.FailedRequestException;
import com.spectralogic.ds3client.networking.Headers;
import com.spectralogic.ds3client.networking.ResponseProcessingException;
import com.spectralogic.ds3client.networking.WebResponse;
import com.spectralogic.ds3client.serializer.XmlOutput;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

public abstract class AbstractResponse implements Ds3Response{
    final private static Logger LOG = LoggerFactory.getLogger(AbstractResponse.class);

    final public static String UTF8 = "UTF-8";

    final private WebResponse response;
    final private String checksum;
    final private Checksum.Type checksumType;

    public AbstractResponse(final WebResponse response) throws IOException {
        this.response = response;
        if (response != null) {
            this.checksumType = determineChecksumType(this.response.getHeaders());
            if (this.checksumType != null) {
                this.checksum = getFirstHeaderValue(this.response.getHeaders(), "content-" + checksumType.toString().toLowerCase());
            } else {
                this.checksum = null;
            }
        }
        else {
            this.checksum = null;
            this.checksumType = Checksum.Type.NONE;
        }
        this.processResponse();
    }

    private static Checksum.Type determineChecksumType(final Headers headers) throws ResponseProcessingException {
        for (final Checksum.Type type : Checksum.Type.values()) {
            if (getFirstHeaderValue(headers, "content-" + type.toString().toLowerCase()) != null) {
                return type;
            }
        }
        LOG.debug("Did not find a content checksum header");
        return null;
    }

    static protected String getFirstHeaderValue(final Headers headers, final String key) {
        final List<String> valueList = headers.get(key);
        if (valueList == null || valueList.isEmpty()) {
            return null;
        } else {
            return valueList.get(0);
        }
    }

    protected abstract void processResponse() throws IOException;

    public  WebResponse getResponse() {
        return this.response;
    }

    public void checkStatusCode(final int ... expectedStatuses) throws IOException {
        final ImmutableSet<Integer> expectedSet = this.createExpectedSet(expectedStatuses);
        final int statusCode = this.getStatusCode();
        if (!expectedSet.contains(statusCode)) {
            final String responseString = this.readResponseString();
            throw new FailedRequestException(
                toImmutableIntList(expectedStatuses),
                statusCode,
                parseErrorResponse(responseString),
                responseString
            );
        }
    }

    private static ImmutableList<Integer> toImmutableIntList(final int[] expectedStatuses) {
        final ImmutableList.Builder<Integer> integerBuilder = ImmutableList.builder();

        for (final int status : expectedStatuses) {
            integerBuilder.add(status);
        }
        return integerBuilder.build();
    }

    public int getStatusCode() {
        return this.response.getStatusCode();
    }

    private ImmutableSet<Integer> createExpectedSet(final int[] expectedStatuses) {
        final ImmutableSet.Builder<Integer> setBuilder = ImmutableSet.builder();
        for(final int status: expectedStatuses) {
            setBuilder.add(status);
        }
        return setBuilder.build();
    }

    private static Error parseErrorResponse(final String responseString) {
        if (Strings.isNullOrEmpty(responseString)) {
            return null;
        }
        try {
            return XmlOutput.fromXml(responseString, Error.class);
        } catch (final IOException e) {
            // It's likely the response string is not in a valid error format.
            LOG.error("Failed to parse error response", e);
            return null;
        }
    }
    
    private String readResponseString() throws IOException {
        if (this.response == null || this.response.getResponseStream() == null) {
            return "";
        }
        try(final StringWriter writer = new StringWriter();
            final InputStream content = this.response.getResponseStream()) {
            IOUtils.copy(content, writer, UTF8);
            return writer.toString();
        }
    }

    public String getChecksum() {
        return checksum;
    }

    public Checksum.Type getChecksumType() {
        return checksumType;
    }
}
