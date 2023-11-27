package com.ontop.martinez.interview.user.domain.model;

import com.ontop.martinez.interview.account.domain.model.Account;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String countryId;
    private List<Account> account;

}
