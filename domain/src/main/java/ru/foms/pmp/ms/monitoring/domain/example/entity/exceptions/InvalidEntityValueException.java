package ru.foms.pmp.ms.monitoring.domain.example.entity.exceptions;

public final class InvalidEntityValueException extends EntityException {

    public InvalidEntityValueException() {
        super("The value is invalid");
    }
}
