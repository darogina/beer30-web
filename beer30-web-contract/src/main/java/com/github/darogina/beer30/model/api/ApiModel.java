package com.github.darogina.beer30.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface ApiModel {
    String getApiVersion();
}
