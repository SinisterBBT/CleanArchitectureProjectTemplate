package ru.foms.pmp.ms.monitoring.usecase.usecaseexample;

import ru.foms.pmp.ms.monitoring.domain.example.EntityValidatorExample;
import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.EntityId;
import ru.foms.pmp.ms.monitoring.domain.example.entity.exceptions.InvalidEntityValueException;
import ru.foms.pmp.ms.monitoring.usecase.integration.UseCaseCreateNewEntityExample;
import ru.foms.pmp.ms.monitoring.usecase.persistence.UseCaseExamplePersister;

public class UseCaseCreateNewEntityExampleImpl implements UseCaseCreateNewEntityExample {

    private final UseCaseExamplePersister persister;

    public UseCaseCreateNewEntityExampleImpl(UseCaseExamplePersister persister) {
        this.persister = persister;
    }

    @Override
    public EntityId createEntity(Entity entity) throws InvalidEntityValueException {
        EntityValidatorExample.validate(entity);
        return persister.save(entity);
    }
}
