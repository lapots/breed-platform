package com.lapots.breed.platform.guice.annotation;

import com.google.inject.AbstractModule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
// make annotation visible in runtime for AspectJ
@Retention(RetentionPolicy.RUNTIME)
public @interface GuiceInject {
    Class<? extends AbstractModule> module();
}
