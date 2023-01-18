package ru.foms.pmp.ms.monitoring.domain.example;

import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.exceptions.InvalidEntityValueException;

public class EntityValidatorExample {

    public static void validate(Entity entity) throws InvalidEntityValueException {

        if("invalid".equals(entity.value())) {
            throw new InvalidEntityValueException();
        }

    }
}