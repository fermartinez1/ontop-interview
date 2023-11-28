package com.ontop.martinez.interview.payment.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontop.martinez.interview.company.domain.model.Company;
import com.ontop.martinez.interview.payment.application.ports.output.PaymentOutputPort;
import com.ontop.martinez.interview.payment.domain.model.Payment;
import com.ontop.martinez.interview.payment.infrastructure.rest.data.request.PaymentDTO;
import com.ontop.martinez.interview.payment.infrastructure.rest.data.request.SourceInformationDTO;
import com.ontop.martinez.interview.payment.infrastructure.rest.data.response.PaymentResponseDTO;
import com.ontop.martinez.interview.payment.infrastructure.rest.mappers.PaymentMapper;
import com.ontop.martinez.interview.person.domain.model.Person;
import com.ontop.martinez.interview.payment.domain.exception.ProviderPaymentException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class PaymentRestAdapter implements PaymentOutputPort {

    public static final String URL_PAYMENT_PROVIDER = "http://mockoon.tools.getontop.com:3000/api/v1/payments";
    private final PaymentMapper paymentMapper;

    @Override
    public Optional<Payment> createPaymentInProvider(Payment payment) {

        try {
            PaymentDTO paymentDTO = paymentMapper.paymentToPaymentDto(payment);


            setSourceFields(payment, paymentDTO);
            setDestinationFields(payment, paymentDTO);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<PaymentDTO> requestEntity = new HttpEntity<>(paymentDTO, headers);

            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI(URL_PAYMENT_PROVIDER);


            ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, requestEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                ObjectMapper mapper = new ObjectMapper();
                PaymentResponseDTO paymentResponseDTO = mapper.readValue(responseEntity.getBody(), PaymentResponseDTO.class);
                payment.setStatus(paymentResponseDTO.getRequestInfoDTO().getStatus());
                log.info("Provider payment success with status: " + payment.getStatus());
            } else {
                log.info("Provider payment failed");
                return Optional.empty();
            }
            return Optional.of(payment);
        } catch (Exception ex) {
            throw new ProviderPaymentException("Error calling payment provider");
        }
    }

    private void setDestinationFields(Payment payment, PaymentDTO paymentDTO) {

        if (payment.getDestination().getUser() instanceof Company) {
            paymentDTO.getDestination().setName(((Company) payment.getDestination().getUser()).getName());
        } else {
            Person person = ((Person) payment.getDestination().getUser());
            paymentDTO.getDestination().setName((person.getName().concat(" ").concat(person.getLastname())));
        }

    }

    private static void setSourceFields(Payment payment, PaymentDTO paymentDTO) {
        if (payment.getSource().getUser() instanceof Company) {
            paymentDTO.getSource().setType("COMPANY");
            SourceInformationDTO sourceInformationDTO = new SourceInformationDTO();
            sourceInformationDTO.setName(((Company) payment.getSource().getUser()).getName());
            paymentDTO.getSource().setSourceInformation(sourceInformationDTO);
        } else {
            paymentDTO.getSource().setType("PERSON");
            SourceInformationDTO sourceInformationDTO = new SourceInformationDTO();
            Person person = ((Person) payment.getSource().getUser());
            sourceInformationDTO.setName(person.getName().concat(" ").concat(person.getLastname()));
            paymentDTO.getSource().setSourceInformation(sourceInformationDTO);
        }
    }
}
