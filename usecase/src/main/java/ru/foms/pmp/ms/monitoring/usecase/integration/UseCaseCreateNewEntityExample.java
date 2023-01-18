package ru.foms.pmp.ms.monitoring.usecase.integration;

import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.EntityId;
import ru.foms.pmp.ms.monitoring.domain.example.entity.exceptions.InvalidEntityValueException;

public interface UseCaseCreateNewEntityExample {
    EntityId createEntity(Entity request) throws InvalidEntityValueException;
}
