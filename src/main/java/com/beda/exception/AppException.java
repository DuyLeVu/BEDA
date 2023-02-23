package com.beda.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppException extends Exception {
    private static final long serialVersionUID = 1L;

    private String message;
}
