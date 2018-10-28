package com.quinelabs.kafkarestproxy.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  @author mail@prabuddha.me
 *  on 21/06/18.
 */

public class LogUtils {

  private static Logger serverLogger = LogManager.getLogger("server-log");

  public static void info(final String event, final String message, final String topic) {
    serverLogger.info(event+" to post to the topic: "+topic+ ", the message: "+message);
  }

  public static void info(final String message) {
    serverLogger.info(message);
  }

  public static void error(final String error, final String message, final String topic, final String reason) {
    serverLogger.error(error+" to the topic: "+topic+",the message: "+message+" reason:"+reason);
  }

  public static void error(final String message) {
    serverLogger.error(message);
  }

}
