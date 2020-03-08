package com.jg.axonquerytwo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.jg.axoncommons.api.data.Person;
import com.jg.axoncommons.api.events.PersonCreatedEvent;
import com.jg.axoncommons.api.events.PersonUpdatedEvent;
import com.jg.axoncommons.api.queries.FindPersonsQuery;

@Component
public class PersonService {

    private final Map<UUID, Person> persons = new HashMap<>();

    @EventHandler
    public void on(final PersonCreatedEvent event) {
        persons.put(event.getId(), new Person(event.getId(), event.getFirstName(), event.getLastName(), -1));
        System.out.println("Person with ID [" + event.getId() + "] added to Map.");
    }

    @EventHandler
    public void on(final PersonUpdatedEvent event) {
        persons.put(event.getId(), new Person(event.getId(), event.getFirstName(), event.getLastName(), -1));
        System.out.println("Person with ID [" + event.getId() + "] updated in Map.");
    }

    @QueryHandler
    public List<Person> handle(final FindPersonsQuery query) {
        List<Person> personList = new ArrayList<>(persons.values());

        if(null == query.getId()) {
            personList = personList.stream().filter(person -> person.getId().equals(query.getId())).collect(Collectors.toList());
        }

        return personList;
    }
}
