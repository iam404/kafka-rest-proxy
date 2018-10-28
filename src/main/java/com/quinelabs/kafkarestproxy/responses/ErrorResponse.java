package com.quinelabs.kafkarestproxy.responses;

/**
 * @author mail@prabuddha.me on 20/01/18.
 */

public class ErrorResponse extends Response {

  public ErrorResponse(final String message) {
    super(message);
  }

}
