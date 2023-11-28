package com.ontop.martinez.interview.payment.infrastructure.rest.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationDTO {

    private String name;
    @JsonProperty("account")
    private AccountDTO account;
}
