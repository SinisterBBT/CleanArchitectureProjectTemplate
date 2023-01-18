package ru.foms.pmp.ms.monitoring.domain.example.entity;

public record Entity (EntityId id, String value) {

    public Entity(String value) {
        this(new EntityId(null), value);
    }

}
