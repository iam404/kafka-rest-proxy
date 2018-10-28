package com.quinelabs.kafkarestproxy.controllers;

import com.google.gson.Gson;
import com.quinelabs.kafkarestproxy.properties.KafkaProperties;
import com.quinelabs.kafkarestproxy.responses.EventResponse;
import com.quinelabs.kafkarestproxy.responses.exceptions.InvalidTopicException;
import com.quinelabs.kafkarestproxy.responses.exceptions.KafkaException;
import com.quinelabs.kafkarestproxy.services.KafkaService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static com.quinelabs.kafkarestproxy.utils.LogUtils.info;

@Controller
@Validated
public class KafkaRestProxy {

  @Autowired
  private KafkaService kafkaService;

  private KafkaProducer<String, String> producer;

  @RequestMapping(value="/", method= RequestMethod.GET)
  @ResponseBody
  public String index() {
    return "index";
  }


  public KafkaRestProxy() throws IOException {
    final Properties properties = new KafkaProperties();
    producer = new KafkaProducer<>(properties);
  }

  @RequestMapping(value="/{topic:.+}", method = RequestMethod.POST, consumes="application/json", produces="application/json")
  @ResponseBody
  public EventResponse processEvent(@PathVariable("topic") String topic,
      @RequestBody LinkedHashMap request)
      throws KafkaException, IOException, InvalidTopicException {
    final Gson gson = new Gson();
    final String event = gson.toJson(request, LinkedHashMap.class);
    if (topic.length() > 0) {

      info("Request received", event, topic);

      kafkaService.processEvent(event, topic);

      final String responseMessage = "Event processed successfully for message received for topic " +topic;
      info(event,"Request processed successfully", topic);
      EventResponse eventResponse = new EventResponse(responseMessage);
      return eventResponse;
    }
    throw new InvalidTopicException("Topic name not provided.");
  }

  @RequestMapping(value="/healthz", method = RequestMethod.GET, produces="application/json")
  @ResponseBody
  public EventResponse healthcheck()
      throws KafkaException, IOException, InvalidTopicException,
      ExecutionException, InterruptedException {
    final String topic = "test.health";
    final String event = "{ \"health\" : \"green\" }";
    final ProducerRecord<String, String> record = new ProducerRecord<>(topic, event);
    producer.send(record).get();
    return new EventResponse(event);
  }



}
