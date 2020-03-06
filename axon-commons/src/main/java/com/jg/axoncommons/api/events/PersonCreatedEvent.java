package com.jg.axoncommons.api.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class PersonCreatedEvent {

    private final UUID id;
    private final String firstName;
    private final String lastName;

}
