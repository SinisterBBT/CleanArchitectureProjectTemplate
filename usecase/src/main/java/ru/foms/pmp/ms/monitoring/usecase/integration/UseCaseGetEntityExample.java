package ru.foms.pmp.ms.monitoring.usecase.integration;

import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.EntityId;

public interface UseCaseGetEntityExample {
    Entity getEntityById(EntityId request);
}
