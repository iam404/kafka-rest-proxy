package com.quinelabs.kafkarestproxy.constants;

import kafka.admin.RackAwareMode;
import kafka.admin.RackAwareMode.Safe$;


public class KafkaConstant {

  public final static int SESSION_TIMEOUT_MS  = 10000;
  public final static int CONNECTION_TIMEOUT_MS = 10000;
  public final static RackAwareMode rackAwareMode = Safe$.MODULE$;
}
