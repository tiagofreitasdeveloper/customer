package br.com.pan.customer.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Address {

    private String postalCode;

    private String street;

    private String number;

    private String district;

    private String complement;

    private String city;

    private String state;
}
