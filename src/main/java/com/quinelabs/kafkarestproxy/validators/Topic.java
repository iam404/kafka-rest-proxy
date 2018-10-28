package com.quinelabs.kafkarestproxy.validators;

import com.quinelabs.kafkarestproxy.validators.impl.TopicValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Constraint(validatedBy = TopicValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Topic {

  String message() default "{Topic} name is a not a valid topic, must follow pattern <app_name>.<tenant_id>";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
