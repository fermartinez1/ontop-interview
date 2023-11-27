package com.ontop.martinez.interview.account.domain.model;

import com.ontop.martinez.interview.user.domain.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long accountNumber;
    private String currency;
    private Long routingNumber;
    private String bankName;
    private User user;
}
