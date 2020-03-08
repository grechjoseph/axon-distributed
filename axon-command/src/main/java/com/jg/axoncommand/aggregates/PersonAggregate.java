package com.jg.axoncommand.aggregates;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.jg.axoncommons.api.commands.CreatePersonCommand;
import com.jg.axoncommons.api.commands.UpdatePersonCommand;
import com.jg.axoncommons.api.events.PersonCreatedEvent;
import com.jg.axoncommons.api.events.PersonUpdatedEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class PersonAggregate {

    @AggregateIdentifier
    private UUID id;
    private String firstName;
    private String lastName;

    @CommandHandler
    public PersonAggregate(final CreatePersonCommand command) {
        AggregateLifecycle.apply(new PersonCreatedEvent(command.getId(), command.getFirstName(), command.getLastName(), command.getAge()));
    }

    @CommandHandler
    public void handle(final UpdatePersonCommand command) {
        AggregateLifecycle.apply(new PersonUpdatedEvent(command.getId(), command.getFirstName(), command.getLastName()));
    }

    @EventSourcingHandler
    public void on(final PersonCreatedEvent event) {
        id = event.getId();
        firstName = event.getFirstName();
        lastName = event.getLastName();
    }

    @EventSourcingHandler
    public void on(final PersonUpdatedEvent event) {
        firstName = event.getFirstName();
        lastName = event.getLastName();
    }
}
