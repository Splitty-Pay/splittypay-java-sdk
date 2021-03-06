package com.splittypay.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable {

    //private static final long serialVersionUID = -790843377907574526L; //NOSONAR

    @Getter
    @NoArgsConstructor
    public static class ErrorDetail implements Serializable {

        //private static final long serialVersionUID = -7071300361893825402L; //NOSONAR

        @JsonProperty("field")
        private String field;

        @JsonProperty("message")
        private List<String> messages;
    }

    @JsonProperty("error")
    private String errorMessage;

    @JsonProperty("errors")
    private List<ErrorDetail> details  = Collections.emptyList(); //NOSONAR
}
