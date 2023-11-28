package com.ontop.martinez.interview.payment.infrastructure.rest.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponseDTO {

    @JsonProperty("paymentInfo")
    private PaymentInfoDTO paymentInfoDTO;
    @JsonProperty("requestInfo")
    private RequestInfoDTO requestInfoDTO;
}
