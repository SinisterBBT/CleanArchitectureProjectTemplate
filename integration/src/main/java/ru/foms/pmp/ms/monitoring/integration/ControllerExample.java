package ru.foms.pmp.ms.monitoring.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.foms.pmp.ms.monitoring.domain.example.entity.Entity;
import ru.foms.pmp.ms.monitoring.domain.example.entity.EntityId;
import ru.foms.pmp.ms.monitoring.domain.example.entity.exceptions.InvalidEntityValueException;
import ru.foms.pmp.ms.monitoring.integration.transport.RequestEntity;
import ru.foms.pmp.ms.monitoring.usecase.integration.UseCaseCreateNewEntityExample;
import ru.foms.pmp.ms.monitoring.usecase.integration.UseCaseGetEntityExample;

@RestController
@RequestMapping("/example")
public class ControllerExample {

    private final UseCaseGetEntityExample useCaseGetEntityExample;

    private final UseCaseCreateNewEntityExample useCaseCreateNewEntityExample;

    @Autowired
    public ControllerExample(UseCaseGetEntityExample useCaseGetEntityExample, UseCaseCreateNewEntityExample useCaseCreateNewEntityExample) {
        this.useCaseGetEntityExample = useCaseGetEntityExample;
        this.useCaseCreateNewEntityExample = useCaseCreateNewEntityExample;
    }

    @GetMapping
    public String getEntity(@RequestParam String id) {
        return useCaseGetEntityExample.getEntityById(new EntityId(id)).value();
    }

    @PostMapping
    public ResponseEntity<String> createEntity(@RequestBody RequestEntity entityToAdd) {
        try {
            var response = useCaseCreateNewEntityExample.createEntity(new Entity(entityToAdd.entityToAdd())).toString();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (InvalidEntityValueException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

    }

}
