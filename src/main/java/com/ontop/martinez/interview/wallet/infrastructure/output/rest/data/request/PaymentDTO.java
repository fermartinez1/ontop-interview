package com.ontop.martinez.interview.wallet.infrastructure.output.rest.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    @JsonProperty("destination")
    private DestinationDTO destinationDTO;
    @JsonProperty("source")
    private SourceDTO sourceDTO;
    private Double amount;
}
