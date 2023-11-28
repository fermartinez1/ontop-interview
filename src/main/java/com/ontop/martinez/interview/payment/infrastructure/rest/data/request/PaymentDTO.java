package com.ontop.martinez.interview.payment.infrastructure.rest.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDTO {
    @JsonProperty("destination")
    private DestinationDTO destination;
    @JsonProperty("source")
    private SourceDTO source;
    private BigDecimal amount;
}
