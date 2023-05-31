package br.com.pan.customer.adapter.repository.feign.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    @JsonProperty("logradouro")
    private String street;

    @JsonProperty("bairro")
    private String district;

    @JsonProperty("localidade")
    private String city;

    @JsonProperty("uf")
    private String state;
}
