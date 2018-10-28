package com.quinelabs.kafkarestproxy.properties;

import com.google.common.io.Resources;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author mail@prabuddha.me
 * on 16/01/18.
 */
@Component
public class KafkaProperties extends Properties {

  private final String BOOTSTRAP_SERVERS = "bootstrap.servers";
  private final String ACKS = "acks";
  private final String RETRIES = "retries";
  private final String BATCH_SIZE = "batch.size";
  private final String AUTO_COMMIT_INTERVAL_MS = "auto.commit.interval.ms";
  private final String KEY_SERIALIZER = "key.serializer";
  private final String VALUE_SERIALIZER = "value.serializer";
  private final String BLOCK_ON_BUFFER_FULL = "block.on.buffer.full";

  private final String KAFKA_BOOTSTRAP_SERVERS = "KAFKA_BOOTSTRAP_SERVERS";
  private final String KAFKA_ACKS = "KAFKA_ACKS";
  private final String KAFKA_RETRIES = "KAFAK_RETRIES";
  private final String KAFKA_BATCH_SIZE = "KAFKA_BATCH_SIZE";
  private final String KAFKA_AUTO_COMMIT_INTERVAL_MS = "KAFKA_AUTO_COMMIT_INTERVAL_MS";
  private final String KAFKA_KEY_SERIALIZER = "KAFKA_KEY_SERIALIZER";
  private final String KAFKA_VALUE_SERIALIZER = "KAFKA_VALUE_SERIALIZER";
  private final String KAFKA_BLOCK_ON_BUFFER_FULL = "KAFKA_BLOCK_ON_BUFFER_FULL";
  private final String SECURITY_PROTOCOL_CONFIG = "SECURITY_PROTOCOL_CONFIG";

  private final String SSL_TRUSTSTORE_LOCATION_CONFIG ="/opt/kafka/config/tls/kafka.client.keystore.jks";
  private final String KAFKA_SSL_TRUSTSTORE_LOCATION_CONFIG = "ssl.truststore.location";
  private final String SSL_TRUSTSTORE_PASSWORD_CONFIG = "SSL_TRUSTSTORE_PASSWORD_CONFIG";
  private final String KAFKA_SSL_TRUSTSTORE_PASSWORD_CONFIG = "ssl.truststore.password";
  private final String SSL_KEYSTORE_LOCATION_CONFIG ="/opt/kafka/config/tls/kafka.client.keystore.jks";
  private final String KAFKA_SSL_KEYSTORE_LOCATION_CONFIG = "ssl.keystore.location";
  private final String SSL_KEYSTORE_PASSWORD_CONFIG = "SSL_KEYSTORE_PASSWORD_CONFIG";
  private final String KAFKA_SSL_KEYSTORE_PASSWORD_CONFIG = "ssl.keystore.password";
  private final String KAFKA_SSL_KEY_PASSWORD = "ssl.key.password";
  private final String SSL_KEY_PASSWORD = "SSL_KEY_PASSWORD";


  public KafkaProperties() throws IOException {
    /*
    Print all Environment variables set on start.
     */

    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
      System.out.format("%s=%s%n", envName, env.get(envName));
    }

    Properties properties = this;
    try (InputStream props = Resources.getResource("producer.props").openStream()) {
      properties.load(props);
      if (System.getenv(KAFKA_BOOTSTRAP_SERVERS) != null) {
        properties.setProperty(BOOTSTRAP_SERVERS, System.getenv(KAFKA_BOOTSTRAP_SERVERS));
      }
      if (System.getenv(KAFKA_ACKS) != null) {
        properties.setProperty(ACKS, System.getenv(KAFKA_ACKS));
      }
      if (System.getenv(KAFKA_RETRIES) != null) {
        properties.setProperty(RETRIES, System.getenv(KAFKA_RETRIES));
      }
      if (System.getenv(KAFKA_BATCH_SIZE) != null) {
        properties.setProperty(BATCH_SIZE, System.getenv(KAFKA_BATCH_SIZE));
      }
      if (System.getenv(KAFKA_AUTO_COMMIT_INTERVAL_MS) != null) {
        properties.setProperty(AUTO_COMMIT_INTERVAL_MS, System.getenv(KAFKA_AUTO_COMMIT_INTERVAL_MS));
      }
      if (System.getenv(KAFKA_KEY_SERIALIZER) != null) {
        properties.setProperty(KEY_SERIALIZER, System.getenv(KAFKA_KEY_SERIALIZER));
      }
      if (System.getenv(KAFKA_VALUE_SERIALIZER) != null) {
        properties.setProperty(VALUE_SERIALIZER, System.getenv(KAFKA_VALUE_SERIALIZER));
      }
      if (System.getenv(KAFKA_BLOCK_ON_BUFFER_FULL) != null) {
        properties.setProperty(BLOCK_ON_BUFFER_FULL, System.getenv(KAFKA_BLOCK_ON_BUFFER_FULL));
      }
      if (System.getenv(SECURITY_PROTOCOL_CONFIG) != null) {
        properties.setProperty(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, System.getenv(SECURITY_PROTOCOL_CONFIG));
      }
      //client certificate path
      if (System.getenv(SSL_TRUSTSTORE_LOCATION_CONFIG) != null) {
        System.out.println("KAFKA_SSL_TRUSTSTORE_LOCATION_CONFIG :"+ KAFKA_SSL_TRUSTSTORE_LOCATION_CONFIG);
        System.out.println("SSL_TRUSTSTORE_LOCATION_CONFIG :"+ System.getenv(SSL_TRUSTSTORE_LOCATION_CONFIG));
        properties.setProperty(KAFKA_SSL_TRUSTSTORE_LOCATION_CONFIG, System.getenv(SSL_TRUSTSTORE_LOCATION_CONFIG));
      }

      if (System.getenv(SSL_TRUSTSTORE_PASSWORD_CONFIG) != null) {
        properties.setProperty(KAFKA_SSL_TRUSTSTORE_PASSWORD_CONFIG, System.getenv(SSL_TRUSTSTORE_PASSWORD_CONFIG));
      }

      if (System.getenv(SSL_KEYSTORE_LOCATION_CONFIG) != null) {
        properties.setProperty(KAFKA_SSL_KEYSTORE_LOCATION_CONFIG, System.getenv(SSL_KEYSTORE_LOCATION_CONFIG));
      }

      if (System.getenv(SSL_KEYSTORE_PASSWORD_CONFIG) != null) {
        properties.setProperty(KAFKA_SSL_KEYSTORE_PASSWORD_CONFIG, System.getenv(SSL_KEYSTORE_PASSWORD_CONFIG));
      }

      if (System.getenv(SSL_KEY_PASSWORD) != null) {
        properties.setProperty(KAFKA_SSL_KEY_PASSWORD, System.getenv(SSL_KEY_PASSWORD));
      }

    }
  }
}
