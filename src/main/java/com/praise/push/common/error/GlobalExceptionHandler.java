package com.praise.push.common.error;

import com.praise.push.common.ErrorCode;
import com.praise.push.common.error.dto.ErrorResponseDto;
import com.praise.push.common.monitoring.MonitoringProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MonitoringProvider monitoringProvider;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(
            final Exception exception,
            final HttpServletRequest request
    ) {
        log.error("Exception: {}, Request URI: {}", exception.getMessage(), request.getRequestURL());
        monitoringProvider.push(exception, request);

        return ErrorResponseDto.build(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
