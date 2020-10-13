package com.lny.dynamodb.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String firstname;

    private String lastname;

    private String email;

    public String getFullname(){
        return String.format("%s %s", this.firstname, this.lastname);
    }
}
