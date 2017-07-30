package com.lapots.breed.platform;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lapots.breed.platform.console.ConsoleMenuRunner;
import com.lapots.breed.platform.core.di.RepositoryModule;
import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.api.INpcRepository;
import com.lapots.breed.platform.json.JsonParserRunner;

/*
 * Want something like
 *
 * @HibernateApplication
 * @JsonDataApplication
 * @ConsoleApplication
 * public class Example {
 *     @GuiceInject(module=RepositoryModule.class)
 *     private static INpcRepository npcRepository;
 *
 *     public static void main(String[] args) {
 *         System.out.println(npcRepository.readNpcs());
 *     }
 * }
 *
 * Ideally it would be great to combine annotations like this
 *
 * @WithSupport({
 *      HibernateRunner.class,
 *      JsonDataRunner.class,
 *      ConsoleRunner.class
 *  })
 * public class Example {
 *     ....
 * }
 *
 * Both of previous samples are the same as
 *
 * public class Example {
 *      public static void main(String[] args) {
 *          Injector injector = Guice.createInjector(new RepositoryModule());
 *          new JsonParserRunner().loadDataFromFile();
 *          new ConsoleMenuRunner().run();
 *
 *          INpcRepository npcRepository = injector.getInstance(INpcRepository.class);
 *          System.out.println(npcRepository.readNpcs());
 *
 *          Hibernate.CONTEXT.stopHibernate();
 *      }
 * }
 *
 */
public class Example {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new RepositoryModule());
        new JsonParserRunner().loadDataFromFile();
        new ConsoleMenuRunner().run();

        INpcRepository npcRepository = injector.getInstance(INpcRepository.class);
        System.out.println(npcRepository.readNpcs());

        Hibernate.CONTEXT.stopHibernate();
    }
}
