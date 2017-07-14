package com.lapots.breed.platform.guice.annotation;

import com.google.inject.AbstractModule;
import com.lapots.breed.platform.guice.GuiceInjector;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Annotation that allows to do injection using Guice
 *
 *    @GuiceInject(module=RepositoryModule.class)
 *    private IRepository repository;
 *
 * During compilation it will transform it into
 *
 *    private IRepository repository = GuiceInjector.getInstance(IRepository.class);
 */
@SupportedAnnotationTypes("com.lapots.breed.platform.guice.annotation.GuiceInject")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GuiceInjectProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        roundEnv.getElementsAnnotatedWith(GuiceInject.class).forEach(element -> {
            GuiceInject annotation = element.getAnnotation(GuiceInject.class); // @GuiceInject(module=RepositoryModule.class)
            Class<? extends AbstractModule> moduleToSearchIn = annotation.module(); // RepositoryModule.class

            // instantiate RepositoryModule.class and pass it to GuiceInjector
            try {
                GuiceInjector.addModule(moduleToSearchIn.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            // generate code
            //      GuiceInjector.getInstance(IRepository.class)
        });

        // init class
        // TODO: verify that it can be done
        GuiceInjector.init();
        return false;
    }
}
