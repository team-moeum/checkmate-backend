package com.checkmate.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T> (ResponseType responseType, T success, ErrorResult error) {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResponseType.SUCCESS, data, null);
    }

    public static ApiResponse<?> fail(String errorMessage) {
        return new ApiResponse<>(ResponseType.FAIL, null, new ErrorResult(errorMessage));
    }

    private record ErrorResult(String message) {
    }
}