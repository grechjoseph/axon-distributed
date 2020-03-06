package com.jg.axoncommons.api.commands;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class UpdatePersonCommand {

    @TargetAggregateIdentifier
    private final UUID id;
    private final String firstName;
    private final String lastName;

}
