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
package com.spectralogic.ds3client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.lang.Integer;
import com.spectralogic.ds3client.models.AutoInspectMode;
import com.spectralogic.ds3client.models.ImportConflictResolutionMode;
import java.util.UUID;
import java.util.Date;
import com.spectralogic.ds3client.models.UnavailableMediaUsagePolicy;

@JacksonXmlRootElement(namespace = "Data")
public class DataPathBackend {

    // Variables
    @JsonProperty("Activated")
    private boolean activated;

    @JsonProperty("AutoActivateTimeoutInMins")
    private Integer autoActivateTimeoutInMins;

    @JsonProperty("AutoInspect")
    private AutoInspectMode autoInspect;

    @JsonProperty("DefaultImportConflictResolutionMode")
    private ImportConflictResolutionMode defaultImportConflictResolutionMode;

    @JsonProperty("Id")
    private UUID id;

    @JsonProperty("LastHeartbeat")
    private Date lastHeartbeat;

    @JsonProperty("UnavailableMediaPolicy")
    private UnavailableMediaUsagePolicy unavailableMediaPolicy;

    @JsonProperty("UnavailablePoolMaxJobRetryInMins")
    private int unavailablePoolMaxJobRetryInMins;

    @JsonProperty("UnavailableTapePartitionMaxJobRetryInMins")
    private int unavailableTapePartitionMaxJobRetryInMins;

    // Constructor
    public DataPathBackend() {
        //pass
    }

    // Getters and Setters
    
    public boolean getActivated() {
        return this.activated;
    }

    public void setActivated(final boolean activated) {
        this.activated = activated;
    }


    public Integer getAutoActivateTimeoutInMins() {
        return this.autoActivateTimeoutInMins;
    }

    public void setAutoActivateTimeoutInMins(final Integer autoActivateTimeoutInMins) {
        this.autoActivateTimeoutInMins = autoActivateTimeoutInMins;
    }


    public AutoInspectMode getAutoInspect() {
        return this.autoInspect;
    }

    public void setAutoInspect(final AutoInspectMode autoInspect) {
        this.autoInspect = autoInspect;
    }


    public ImportConflictResolutionMode getDefaultImportConflictResolutionMode() {
        return this.defaultImportConflictResolutionMode;
    }

    public void setDefaultImportConflictResolutionMode(final ImportConflictResolutionMode defaultImportConflictResolutionMode) {
        this.defaultImportConflictResolutionMode = defaultImportConflictResolutionMode;
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }


    public Date getLastHeartbeat() {
        return this.lastHeartbeat;
    }

    public void setLastHeartbeat(final Date lastHeartbeat) {
        this.lastHeartbeat = lastHeartbeat;
    }


    public UnavailableMediaUsagePolicy getUnavailableMediaPolicy() {
        return this.unavailableMediaPolicy;
    }

    public void setUnavailableMediaPolicy(final UnavailableMediaUsagePolicy unavailableMediaPolicy) {
        this.unavailableMediaPolicy = unavailableMediaPolicy;
    }


    public int getUnavailablePoolMaxJobRetryInMins() {
        return this.unavailablePoolMaxJobRetryInMins;
    }

    public void setUnavailablePoolMaxJobRetryInMins(final int unavailablePoolMaxJobRetryInMins) {
        this.unavailablePoolMaxJobRetryInMins = unavailablePoolMaxJobRetryInMins;
    }


    public int getUnavailableTapePartitionMaxJobRetryInMins() {
        return this.unavailableTapePartitionMaxJobRetryInMins;
    }

    public void setUnavailableTapePartitionMaxJobRetryInMins(final int unavailableTapePartitionMaxJobRetryInMins) {
        this.unavailableTapePartitionMaxJobRetryInMins = unavailableTapePartitionMaxJobRetryInMins;
    }

}