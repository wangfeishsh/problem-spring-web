package org.zalando.problem.spring.web.advice.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.AdviceTrait;

/**
 * @see HttpMediaTypeNotSupportedException
 * @see Status#UNSUPPORTED_MEDIA_TYPE
 */
public interface UnsupportedMediaTypeAdviceTrait extends AdviceTrait {

    @ExceptionHandler
    default ResponseEntity<Problem> handleMediaTypeNotSupportedException(
            final HttpMediaTypeNotSupportedException exception,
            final NativeWebRequest request) {

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(exception.getSupportedMediaTypes());

        return create(Status.UNSUPPORTED_MEDIA_TYPE, exception, request, headers);
    }

}
