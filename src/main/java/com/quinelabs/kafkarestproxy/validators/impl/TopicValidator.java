package com.quinelabs.kafkarestproxy.validators.impl;

import com.quinelabs.kafkarestproxy.validators.Topic;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author by mail@prabuddha.me
 * on 09/05/18.
 */
public class TopicValidator implements ConstraintValidator<Topic, String> {

  @Override public void initialize(final Topic topic) {

  }

  @Override public boolean isValid(final String topic,
      final ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isBlank(topic)) {
      return false;
    }
    return StringUtils.contains(topic, '.');
  }
}
