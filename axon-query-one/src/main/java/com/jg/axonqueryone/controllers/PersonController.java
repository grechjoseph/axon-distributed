package com.jg.axonqueryone.controllers;

import java.util.List;
import java.util.UUID;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jg.axoncommons.api.data.Person;
import com.jg.axoncommons.api.queries.FindPersonsQuery;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final QueryGateway queryGateway;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return queryGateway.query(new FindPersonsQuery(), ResponseTypes.multipleInstancesOf(Person.class)).join();
    }

    @GetMapping("/persons/{personId}")
    public List<Person> getAllPersons(@PathVariable UUID personId) {
        final FindPersonsQuery query = new FindPersonsQuery();
        query.setId(personId);
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(Person.class)).join();
    }
}
