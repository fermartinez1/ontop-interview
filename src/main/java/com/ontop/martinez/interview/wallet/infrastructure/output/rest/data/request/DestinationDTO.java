package com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationDTO {

    private String name;
    @JsonProperty("account")
    private AccountDTO accountDTO;
}
