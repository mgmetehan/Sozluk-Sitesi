package com.Dona.SozlukSitesi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String message;
    private List<String> details;
}