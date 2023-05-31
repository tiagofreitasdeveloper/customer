package br.com.pan.customer.adapter.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {

    private String postalCode;

    private String number;

    private String complement;

    private String street;

    private String district;

    private String city;

    private String state;
}
