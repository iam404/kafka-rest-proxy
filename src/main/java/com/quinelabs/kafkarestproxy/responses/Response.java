package com.quinelabs.kafkarestproxy.responses;

/**
 * @author mail@prabuddha.me
 * on 15/01/18.
 */
public class Response {

  private final String message;

  public Response(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

}
