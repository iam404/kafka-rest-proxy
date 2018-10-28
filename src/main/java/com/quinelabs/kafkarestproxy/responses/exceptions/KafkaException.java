package com.quinelabs.kafkarestproxy.responses.exceptions;

/**
 * @author mail@prabuddha.me
 * on 20/01/18.
 */

public class KafkaException extends Exception {

  private final String message;

  public KafkaException(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
