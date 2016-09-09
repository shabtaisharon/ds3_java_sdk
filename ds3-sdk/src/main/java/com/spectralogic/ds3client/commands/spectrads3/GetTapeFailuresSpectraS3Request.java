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

// This code is auto-generated, do not modify
package com.spectralogic.ds3client.commands.spectrads3;

import com.spectralogic.ds3client.networking.HttpVerb;
import com.spectralogic.ds3client.commands.interfaces.AbstractPaginationRequest;
import com.google.common.net.UrlEscapers;
import java.util.UUID;
import com.spectralogic.ds3client.models.TapeFailureType;

public class GetTapeFailuresSpectraS3Request extends AbstractPaginationRequest {

    // Variables
    
    private String errorMessage;

    private boolean lastPage;

    private int pageLength;

    private int pageOffset;

    private String pageStartMarker;

    private String tapeDriveId;

    private String tapeId;

    private TapeFailureType type;

    // Constructor
    
    public GetTapeFailuresSpectraS3Request() {
        
    }

    public GetTapeFailuresSpectraS3Request withErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
        this.updateQueryParam("error_message", errorMessage);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withLastPage(final boolean lastPage) {
        this.lastPage = lastPage;
        if (this.lastPage) {
            this.getQueryParams().put("last_page", null);
        } else {
            this.getQueryParams().remove("last_page");
        }
        return this;
    }

    public GetTapeFailuresSpectraS3Request withPageLength(final int pageLength) {
        this.pageLength = pageLength;
        this.updateQueryParam("page_length", pageLength);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withPageOffset(final int pageOffset) {
        this.pageOffset = pageOffset;
        this.updateQueryParam("page_offset", pageOffset);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withPageStartMarker(final UUID pageStartMarker) {
        this.pageStartMarker = pageStartMarker.toString();
        this.updateQueryParam("page_start_marker", pageStartMarker);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withPageStartMarker(final String pageStartMarker) {
        this.pageStartMarker = pageStartMarker;
        this.updateQueryParam("page_start_marker", pageStartMarker);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withTapeDriveId(final UUID tapeDriveId) {
        this.tapeDriveId = tapeDriveId.toString();
        this.updateQueryParam("tape_drive_id", tapeDriveId);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withTapeDriveId(final String tapeDriveId) {
        this.tapeDriveId = tapeDriveId;
        this.updateQueryParam("tape_drive_id", tapeDriveId);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withTapeId(final UUID tapeId) {
        this.tapeId = tapeId.toString();
        this.updateQueryParam("tape_id", tapeId);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withTapeId(final String tapeId) {
        this.tapeId = tapeId;
        this.updateQueryParam("tape_id", tapeId);
        return this;
    }

    public GetTapeFailuresSpectraS3Request withType(final TapeFailureType type) {
        this.type = type;
        this.updateQueryParam("type", type);
        return this;
    }


    @Override
    public HttpVerb getVerb() {
        return HttpVerb.GET;
    }

    @Override
    public String getPath() {
        return "/_rest_/tape_failure";
    }
    
    public String getErrorMessage() {
        return this.errorMessage;
    }


    public boolean getLastPage() {
        return this.lastPage;
    }


    public int getPageLength() {
        return this.pageLength;
    }


    public int getPageOffset() {
        return this.pageOffset;
    }


    public String getPageStartMarker() {
        return this.pageStartMarker;
    }


    public String getTapeDriveId() {
        return this.tapeDriveId;
    }


    public String getTapeId() {
        return this.tapeId;
    }


    public TapeFailureType getType() {
        return this.type;
    }

}