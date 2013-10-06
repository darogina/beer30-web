package com.github.darogina.beer30.model.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface ApiModel {
    @JsonIgnore
    String getApiVersion();
}
