package ru.foms.pmp.ms.monitoring.domain.example.entity.exceptions;

import ru.foms.pmp.ms.monitoring.exception.BusinessException;

public sealed class EntityException extends BusinessException permits InvalidEntityValueException {

    public EntityException(String message) {
        super(message);
    }
}
