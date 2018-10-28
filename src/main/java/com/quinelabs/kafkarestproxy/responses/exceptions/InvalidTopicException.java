package com.quinelabs.kafkarestproxy.responses.exceptions;

/**
 * @author  by mail@prabuddha.me on 16/01/18.
 */
public class InvalidTopicException extends Exception {

  private final String message;

  public InvalidTopicException(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
