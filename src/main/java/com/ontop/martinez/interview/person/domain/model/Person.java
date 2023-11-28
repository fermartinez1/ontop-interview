package com.ontop.martinez.interview.person.domain.model;

import com.ontop.martinez.interview.user.domain.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends User {

    private Long id;
    private Long birthDate;
    private String lastname;

}
