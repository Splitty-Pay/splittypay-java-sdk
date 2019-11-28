package com.splittypay.exception;

import lombok.Getter;
import retrofit2.Call;

import static java.lang.String.format;

@Getter
public class SplittyPayCallException extends RuntimeException {

    private final transient Call<?> call;

    public SplittyPayCallException(final Call<?> call, Throwable cause) {
        super(
                format("Call %s %s failed with cause %s", call.request().method(), call.request().url(), cause),
                cause
        );
        this.call = call;
    }
}
