package com.shoppro.shoppro_auth.util;


import com.shoppro.shoppro_auth.dto.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseUtil {

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> fail(String message) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> status(HttpStatus status, String message, T data) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(status.is2xxSuccessful())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status).body(response);
    }

    public static <T> ResponseEntity<List<T>> list(List<T> data) {
        return ResponseEntity.ok(data);
    }
}