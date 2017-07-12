package com.lapots.breed.platform;

import com.lapots.breed.platform.core.repository.RepositoryComponent;
import com.lapots.breed.platform.core.repository.domain.MainCharacter;
import com.lapots.breed.platform.core.repository.DaggerRepositoryComponent;
import com.lapots.breed.platform.core.repository.impl.GenderRepository;

import javax.inject.Inject;

public class Example {

    @Inject
    GenderRepository genderRepository;
    public void execute() {
        genderRepository.readGenders();
    }

    public static void main(String[] args) {
        Example example = new Example();
        MainCharacter character = new MainCharacter();
        RepositoryComponent repositoryComponent = DaggerRepositoryComponent.builder()
                .provideGenderRepository().build();
        repositoryComponent.inject(example);
        example.execute();
    }
}
