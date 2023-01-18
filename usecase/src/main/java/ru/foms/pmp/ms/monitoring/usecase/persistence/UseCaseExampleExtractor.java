package ru.foms.pmp.ms.monitoring.usecase.persistence;

import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.EntityId;

public interface UseCaseExampleExtractor {

    Entity extract(EntityId id);
}
