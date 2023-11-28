package com.ontop.martinez.interview.payment.infrastructure.rest.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SourceDTO {

    private String type;
    @JsonProperty("account")
    private AccountDTO account;
    @JsonProperty("sourceInformation")
    private SourceInformationDTO sourceInformation;

}
