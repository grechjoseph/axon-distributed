package com.jg.axoncommons.api.commands;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class CreatePersonCommand {

    private UUID id = UUID.randomUUID();
    private final String firstName;
    private final String lastName;

}
