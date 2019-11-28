package com.splittypay.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.splittypay.exception.SplittyPayCallException;
import com.splittypay.exception.SplittyPayErrorException;
import com.splittypay.exception.SplittyPayErrorType;
import com.splittypay.model.Error;
import io.vavr.Tuple2;
import io.vavr.control.Try;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.io.IOException;
import java.util.function.Function;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.Predicates.instanceOf;

@Slf4j
@Value(staticConstructor = "of")
class SplittyPayCallExecutor<T> {

    private Call<T> call;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .registerModule(new JavaTimeModule())
            .registerModule(new Jdk8Module());

    @SuppressWarnings("unchecked")
    T getResponse() {
        return Try.of(call::execute)
                .filter(Response::isSuccessful, createErrorException())
                .map(Response::body)
                .mapFailure(Case($(instanceOf(IOException.class)), error -> new SplittyPayCallException(call, error)))
                .onFailure(e -> log.error("Call {} failed with error: {}", call.request(), e.getMessage()))
                .get();
    }

    private Function<Response<?>, SplittyPayErrorException> createErrorException() {
        return response -> Try.of(() -> new Tuple2<>(response.code(), response.errorBody()))
                .mapTry(tuple -> {
                    SplittyPayErrorType errorType = SplittyPayErrorType.byHttpCode(tuple._1).orElse(SplittyPayErrorType.UNKNOWN);
                    Error error = OBJECT_MAPPER.readerFor(Error.class).readValue(tuple._2.string());
                    return new SplittyPayErrorException(errorType, error);
                })
                .getOrElse(SplittyPayErrorException.GENERIC_SPLITTYPAY_ERROR);
    }
}
