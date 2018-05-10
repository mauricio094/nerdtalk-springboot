package com.netsneakers.sneakers.api.v1;

import com.netsneakers.sneakers.domain.exception.NotFoundException;
import com.netsneakers.sneakers.domain.exception.SneakerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public HttpEntity<ErrorResponse> handleNotFoundException(HttpServletRequest req, NotFoundException ex) {
        log.error(ex.getMessage(), ex);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createErrorResponse(ex), responseHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SneakerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public HttpEntity<ErrorResponse> handleThrowable(HttpServletRequest req, SneakerException ex) {
        log.error(ex.getMessage(), ex);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createErrorResponse(ex), responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public HttpEntity<ErrorResponse> handleThrowable(HttpServletRequest req, Throwable ex) {
        log.error(ex.getMessage(), ex);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(createErrorResponse(ex), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse createErrorResponse(Throwable ex) {
        ErrorResponse errorResponse = null;
        if (StringUtils.isNotBlank(ex.getMessage())) {
            errorResponse = new ErrorResponse(ex.getMessage());
        }
        return errorResponse;
    }

}
