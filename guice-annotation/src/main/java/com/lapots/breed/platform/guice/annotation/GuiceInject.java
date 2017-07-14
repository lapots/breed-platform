package com.lapots.breed.platform.guice.annotation;

import com.google.inject.AbstractModule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface GuiceInject {
    Class<? extends AbstractModule> module();
}
