package com.jg.axoncommons.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Person {

    private UUID id;
    private String firstName;
    private String lastName;
    private int age;

}
