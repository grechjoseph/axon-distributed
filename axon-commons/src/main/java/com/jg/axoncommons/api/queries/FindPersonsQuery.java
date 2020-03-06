package com.jg.axoncommons.api.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindPersonsQuery {

    private UUID id;
    private String firstName;
    private String lastName;

}
