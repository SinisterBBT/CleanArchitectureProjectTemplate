package ru.foms.pmp.ms.monitoring.persistence;

import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.EntityId;
import ru.foms.pmp.ms.monitoring.usecase.persistence.UseCaseExampleExtractor;
import ru.foms.pmp.ms.monitoring.usecase.persistence.UseCaseExamplePersister;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class InMemoryUseCaseExampleRepository implements UseCaseExampleExtractor, UseCaseExamplePersister {

    Map<EntityId, Entity> storage = new HashMap<>();

    {
        var entityId = new EntityId("InitialId");
        storage.put(entityId, new Entity(entityId, "InitialValue"));
    }

    @Override
    public Entity extract(EntityId id) {
        return storage.get(id);
    }

    @Override
    public EntityId save(Entity entity) {
        var key = new EntityId(UUID.randomUUID().toString());
        var value = new Entity(key, entity.value());
        storage.put(key, value);
        return key;
    }
}
