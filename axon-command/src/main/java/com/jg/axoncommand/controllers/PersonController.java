package com.jg.axoncommand.controllers;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jg.axoncommons.api.commands.CreatePersonCommand;
import com.jg.axoncommons.api.commands.UpdatePersonCommand;
import com.jg.axoncommons.api.data.Person;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final CommandGateway commandGateway;

    @PostMapping("/persons")
    public String createPerson(@RequestBody Person person) {
        UUID generatedId = (UUID) commandGateway.send(new CreatePersonCommand(person.getFirstName(), person.getLastName())).join();
        return "Person created with ID: " + generatedId + ".";
    }

    @PutMapping("/persons/{personId}")
    public String createPerson(@PathVariable UUID personId, @RequestBody Person person) {
        commandGateway.send(new UpdatePersonCommand(personId, person.getFirstName(), person.getLastName())).join();
        return "Person with ID: " + personId + " updated.";
    }
}
