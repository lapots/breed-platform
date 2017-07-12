package com.lapots.breed.platform.core.repository;

import com.lapots.breed.platform.Example;
import com.lapots.breed.platform.core.repository.module.RepositoryModule;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules=RepositoryModule.class)
@Singleton
public interface RepositoryComponent {
    void inject(Example example);
}
