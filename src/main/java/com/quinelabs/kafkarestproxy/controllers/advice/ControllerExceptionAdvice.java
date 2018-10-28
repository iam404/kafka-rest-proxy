package com.quinelabs.kafkarestproxy.controllers.advice;

import com.quinelabs.kafkarestproxy.responses.ErrorResponse;
import com.quinelabs.kafkarestproxy.responses.exceptions.InvalidTopicException;
import com.quinelabs.kafkarestproxy.responses.exceptions.KafkaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.quinelabs.kafkarestproxy.utils.LogUtils.error;


@ControllerAdvice
public class ControllerExceptionAdvice {


  @ExceptionHandler(KafkaException.class)
  @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse handleKafkaEventException(KafkaException ex) {
    final String message = ex.getLocalizedMessage();
    error("KafkaException : " + message);
    return new ErrorResponse(message);
  }

  @ExceptionHandler(InvalidTopicException.class)
  @ResponseStatus(value= HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponse handleInvalidTopicException(InvalidTopicException ex) {
    final String message = ex.getLocalizedMessage();
    error("InvalidTopicException : " + message);

    return new ErrorResponse(message);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ErrorResponse handleOtherException(KafkaException ex) {
    final String message = ex.getLocalizedMessage();
    error("Exception : " + message);

    return new ErrorResponse(message);
  }

}
