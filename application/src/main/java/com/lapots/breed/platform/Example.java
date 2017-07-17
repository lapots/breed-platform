package com.lapots.breed.platform;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.prototype.Person;
import com.lapots.breed.platform.prototype.PersonService;
import com.lapots.breed.platform.prototype.guice.GuiceModule;

public class Example {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        PersonService service = injector.getInstance(PersonService.class);
        Person person = service.findPerson("1"); // ok

        System.out.println ("Created person: " + person);
        Hibernate.CONTEXT.stopHibernate();
    }
}
