package com.lapots.breed.platform.guice.aspect;

import com.lapots.breed.platform.guice.GuiceInjector;
import com.lapots.breed.platform.guice.generated.$GuiceGenerated;

public aspect InjectionAspect {

    Object around(): get(@com.lapots.breed.platform.guice.annotation.GuiceInject * *.*) {
        System.out.println(thisJoinPointStaticPart);
        System.out.println(thisJoinPoint.getTarget().getClass());
        $GuiceInjector.init();
        return $GuiceInjector.getInstance(thisJoinPoint.getTarget().getClass());
    }
}
