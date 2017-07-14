package com.lapots.breed.platform.guice.annotation;

import com.google.inject.AbstractModule;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes("com.lapots.breed.platform.guice.annotation.GuiceInject")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GuiceInjectProcessor extends AbstractProcessor {

    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        boolean hadElement = false;
        for (Element element : roundEnv.getElementsAnnotatedWith(GuiceInject.class)) {
            generateGuiceInjectorClass();

            GuiceInject annotation = element.getAnnotation(GuiceInject.class);

            // https://area-51.blog/2009/02/13/getting-class-values-from-annotations-in-an-annotationprocessor/
            TypeMirror value = null;
            try {
                annotation.module();
            } catch (MirroredTypeException e) {
                value = e.getTypeMirror(); // now we have required value like package.Class there
            }

            // TODO: implement processing flow with class loading and initialization

            if (!hadElement) {
                hadElement = true;
            }
        };
        return hadElement;
    }

    /*
        Generates source code for class

        package com.lapots.breed.platform.guice.generator;

        import com.google.inject.Guice;
        import com.google.inject.Injector;
        import com.google.inject.Module;
        import java.util.ArrayList;
        import java.util.List;

        public class $GuiceInjector {
            private static Injector injector;
            private static List<Module> modules = new ArrayList<>();

            public static void addModule(Module module) { modules.add(module); }

            public static void init() { injector = Guice.createInjector(modules); }

            public static <T> T getInstance(Class<T> clazz) {
                return injector.getInstance(clazz);
            }
        }
     */

    private void generateGuiceInjectorClass() {
        try {
            // check file existence
            filer.getResource(StandardLocation.SOURCE_PATH,
                    "com.lapots.breed.platform.guice.generated", "$GuiceInjector");
        } catch (IOException e) {
            // e.printStackTrace(); // file not found

            TypeSpec.Builder guiceInjectorClass = TypeSpec
                    .classBuilder("$GuiceInjector")
                    .addModifiers(Modifier.PUBLIC);

            try {
                JavaFile.builder("com.lapots.breed.platform.guice.generated", guiceInjectorClass.build())
                        .build()
                        .writeTo(filer);
            } catch (IOException exc) {
                exc.printStackTrace(); // TODO: add logger
            }
        }
    }
}
