package com.quinelabs.kafkarestproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Map;


@EnableAutoConfiguration
@Component
@ComponentScan
@SpringBootApplication
public class App extends SpringBootServletInitializer {

  public static void main(String[] args) {
    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
      System.out.format("%s=%s%n", envName, env.get(envName));
    }
    SpringApplication.run(App.class);
  }

}