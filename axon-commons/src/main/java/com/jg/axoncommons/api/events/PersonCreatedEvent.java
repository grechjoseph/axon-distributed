package com.jg.axoncommons.api.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.axonframework.serialization.Revision;

import java.util.UUID;

@Data
@Revision("2.0")
@RequiredArgsConstructor
public class PersonCreatedEvent {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final int age;

}
