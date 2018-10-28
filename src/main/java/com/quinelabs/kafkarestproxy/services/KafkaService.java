package com.quinelabs.kafkarestproxy.services;

import com.quinelabs.kafkarestproxy.responses.exceptions.KafkaException;
import org.springframework.stereotype.Service;


@Service
public interface KafkaService {

  public void processEvent(final String event, final String topic)
      throws KafkaException;

}
