package com.lapots.breed.platform.guice.annotation;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.lapots.breed.platform.guice.GuiceInjector;
import com.squareup.javapoet.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import java.io.IOException;
import java.util.LinkedHashSet;
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
        Set<String> moduleClasses = new LinkedHashSet<>();
        for (Element element : roundEnv.getElementsAnnotatedWith(GuiceInject.class)) {
            GuiceInject annotation = element.getAnnotation(GuiceInject.class);

            TypeMirror value = null;
            try {
                annotation.module();
            } catch (MirroredTypeException e) {
                value = e.getTypeMirror();
                moduleClasses.add(value.toString());
            }

            if (!hadElement) {
                hadElement = true;
            }
        };
        // load all modules
        generateGuiceInjectorClass(moduleClasses);
        return hadElement;
    }

    private void generateGuiceInjectorClass(Set<String> instantiationModules) {
        TypeSpec.Builder guiceInjectorClass = TypeSpec
                .classBuilder("$GuiceInjector")
                .addModifiers(Modifier.PUBLIC);

        FieldSpec injectorField = FieldSpec.builder(Injector.class, "injector")
                .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
                .build();
        guiceInjectorClass.addField(injectorField);

        FieldSpec modulesField = FieldSpec.builder(ParameterizedTypeName.get(List.class, Module.class), "modules")
                .addModifiers(Modifier.PRIVATE, Modifier.STATIC)
                .initializer("new $T<>()", ClassName.get("java.util", "ArrayList"))
                .build();
        guiceInjectorClass.addField(modulesField);
/*
            // public static void addModule(Module module) { modules.add(module; }
            MethodSpec addModuleMethod = MethodSpec.methodBuilder("addModule")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(void.class)
                    .addParameter(Module.class, "module")
                    .addStatement("modules.add($N)", "module")
                    .build();
            guiceInjectorClass.addMethod(addModuleMethod);
*/
        MethodSpec.Builder initMethodBuilder = MethodSpec.methodBuilder("init")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class);
        for (String moduleName : instantiationModules) {
            String packageName = moduleName.substring(0, moduleName.lastIndexOf("."));
            String className = moduleName.substring(moduleName.lastIndexOf(".") + 1);
            initMethodBuilder.addStatement("$N.add(new $T())", "modules", ClassName.get(packageName, className));
        }
        MethodSpec initMethod = initMethodBuilder
                .addStatement("$N = $T.createInjector($N)", "injector",
                        ClassName.get("com.google.inject", "Guice"), "modules")
                .addStatement("$N.clear()", "modules") // just for lulz
                .build();
        guiceInjectorClass.addMethod(initMethod);

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
            // exc.printStackTrace(); // TODO: add logger
        }
    }
}
