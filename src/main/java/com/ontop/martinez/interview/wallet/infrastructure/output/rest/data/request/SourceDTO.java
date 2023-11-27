package com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SourceDTO {

    private String type;
    @JsonProperty("account")
    private AccountDTO accountDTO;
    @JsonProperty("sourceInformation")
    private SourceInformationDTO sourceInformationDTO;

}
