package org.zalando.problem.springweb.advice;

/*
 * #%L
 * problem-handling
 * %%
 * Copyright (C) 2015 Zalando SE
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;

import javax.ws.rs.core.Response;

import static org.zalando.problem.springweb.EntityBuilder.buildEntity;

@ControllerAdvice
public interface MessageNotReadable {

    @ExceptionHandler
    default ResponseEntity<Problem> handleMessageNotReadableException(final HttpMessageNotReadableException exception,
            final NativeWebRequest request) {

        // TODO: Jackson stuff
        return buildEntity(Response.Status.BAD_REQUEST, exception, request);
    }

}