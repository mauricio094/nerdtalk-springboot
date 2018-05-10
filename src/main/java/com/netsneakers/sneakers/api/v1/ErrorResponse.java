package com.netsneakers.sneakers.api.v1;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private String error;

    public ErrorResponse(String error) {
        this.error = error;

    }
}