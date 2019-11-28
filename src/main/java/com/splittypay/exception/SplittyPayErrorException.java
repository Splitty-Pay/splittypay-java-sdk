package com.splittypay.exception;

import com.splittypay.model.Error;

import static java.lang.String.format;

public class SplittyPayErrorException extends RuntimeException {

    public static final SplittyPayErrorException GENERIC_SPLITTYPAY_ERROR = new SplittyPayErrorException();

    private final SplittyPayErrorType type;
    private final Error error;

    public SplittyPayErrorException(final SplittyPayErrorType type, final Error error) {
        super(format("Error %s (%s). %s. %s", type.name(), type.reason, error.getErrorMessage(), error.getDetails()));
        this.type = type;
        this.error = error;
    }

    private SplittyPayErrorException() {
        super("Unknown error");
        this.type = null;
        this.error = null;
    }
}
