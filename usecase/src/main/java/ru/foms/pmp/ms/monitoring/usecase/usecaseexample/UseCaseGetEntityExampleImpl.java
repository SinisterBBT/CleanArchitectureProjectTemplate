package ru.foms.pmp.ms.monitoring.usecase.usecaseexample;

import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.EntityId;
import ru.foms.pmp.ms.monitoring.usecase.integration.UseCaseGetEntityExample;
import ru.foms.pmp.ms.monitoring.usecase.persistence.UseCaseExampleExtractor;

public class UseCaseGetEntityExampleImpl implements UseCaseGetEntityExample {

    private final UseCaseExampleExtractor extractor;

    public UseCaseGetEntityExampleImpl(UseCaseExampleExtractor extractor) {
        this.extractor = extractor;
    }

    @Override
    public Entity getEntityById(EntityId id) {
        return extractor.extract(id);
    }
}
