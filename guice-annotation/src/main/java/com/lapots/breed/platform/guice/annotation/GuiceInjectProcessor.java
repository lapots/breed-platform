package com.lapots.breed.platform.guice.annotation;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.squareup.javapoet.*;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;
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
            generateGuiceInjectorClass(); // generate Guice infrastructure

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

    private void generateGuiceInjectorClass() {
        try {
            // check file existence
            filer.getResource(StandardLocation.SOURCE_PATH,
                    "com.lapots.breed.platform.guice.generated", "$GuiceInjector");
        } catch (IOException e) {
            // public class $GuiceInjector
            TypeSpec.Builder guiceInjectorClass = TypeSpec
                    .classBuilder("$GuiceInjector")
                    .addModifiers(Modifier.PUBLIC);

            // private static Injector injector
            FieldSpec injectorField = FieldSpec.builder(Injector.class, "injector")
                    .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
                    .build();
            guiceInjectorClass.addField(injectorField);

            // private static List<Module> modules = new ArrayList<>();
            FieldSpec modulesField = FieldSpec.builder(ParameterizedTypeName.get(List.class, Module.class), "modules")
                    .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
                    .initializer("new $T<>()", ClassName.get("java.util", "ArrayList"))
                    .build();
            guiceInjectorClass.addField(modulesField);

            // public static void addModule(Module module) { modules.add(module; }
            MethodSpec addModuleMethod = MethodSpec.methodBuilder("addModule")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(void.class)
                    .addParameter(Module.class, "module")
                    .addStatement("modules.add($N)", "module")
                    .build();
            guiceInjectorClass.addMethod(addModuleMethod);

            // public static void init() { injector = Guice.createInjector(modules); }
            MethodSpec initMethod = MethodSpec.methodBuilder("init")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(void.class)
                    .addStatement("$N = $T.createInjector($N)", "injector",
                            ClassName.get("com.google.inject", "Guice"), "modules")
                    .build();
            guiceInjectorClass.addMethod(initMethod);

            // public static <T> T getInstance(Class<T> clazz) { return injector.getInstance(clazz); }
            TypeVariableName typeVariableName = TypeVariableName.get("T");
            MethodSpec getInstanceMethod = MethodSpec.methodBuilder("getInstance")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .addTypeVariable(typeVariableName)
                    .addParameter(ParameterizedTypeName.get(ClassName.get(Class.class), typeVariableName), "clazz")
                    .addStatement("return $N.getInstance($N)", "injector", "clazz")
                    .returns(typeVariableName)
                    .build();
            guiceInjectorClass.addMethod(getInstanceMethod);

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
