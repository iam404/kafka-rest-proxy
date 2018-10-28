package com.quinelabs.kafkarestproxy.services.impl;
import com.quinelabs.kafkarestproxy.properties.KafkaProperties;
import com.quinelabs.kafkarestproxy.responses.exceptions.KafkaException;
import com.quinelabs.kafkarestproxy.services.KafkaService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.zookeeper.KeeperException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

import static com.quinelabs.kafkarestproxy.utils.LogUtils.error;
import static com.quinelabs.kafkarestproxy.utils.LogUtils.info;

/**
 * @author by mail@prabuddha.me
 * on 16/01/18.
 */

@Service
public class KafkaServiceImpl implements KafkaService {


  private KafkaProducer<String, String> producer;
  private final Properties properties;

  public KafkaServiceImpl()
      throws IOException, KeeperException, InterruptedException {
    properties = new KafkaProperties();
    producer = new KafkaProducer<>(properties);
  }

  @Override
  public void processEvent(final String event, final String topic)
      throws KafkaException {
    final ProducerRecord<String, String> record = new ProducerRecord<>(topic, event);
    try {
      RecordMetadata recordMetadata =  producer.send(record).get();
      info("event is successfully written to the offset " + recordMetadata
          .offset(), event, topic);
    } catch (Exception e) {
      error("Fail to write event to kafka ", event,
          topic, e.getLocalizedMessage());
      final String message = " to post event: "+ event + "to the Topic: " + topic;
      throw new KafkaException("Fail to store event to kafka for "+message);
    }
  }

}
