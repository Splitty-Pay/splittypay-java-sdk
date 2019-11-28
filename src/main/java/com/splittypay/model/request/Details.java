package com.splittypay.model.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Details {

    private String language;

    private String email;
}
