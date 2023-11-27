package com.ontop.martinez.interview.company.domain.model;

import com.ontop.martinez.interview.user.domain.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company extends User {

    private String name;

}
