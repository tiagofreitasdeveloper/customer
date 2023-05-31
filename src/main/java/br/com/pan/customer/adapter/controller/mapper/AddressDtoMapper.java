package br.com.pan.customer.adapter.controller.mapper;

import br.com.pan.customer.adapter.controller.response.AddressResponse;
import br.com.pan.customer.domain.Address;
import br.com.pan.customer.adapter.controller.dto.AddressDto;

public class AddressDtoMapper {

    public static Address toDomain(AddressDto addressDto) {
        return Address.builder()
                .postalCode(addressDto.getPostalCode())
                .number(addressDto.getNumber())
                .complement(addressDto.getComplement())
                .build();
    }

    public static AddressResponse toResponse(Address address) {
        return AddressResponse.builder()
                .postalCode(address.getPostalCode())
                .number(address.getNumber())
                .complement(address.getComplement())
                .street(address.getStreet())
                .district(address.getDistrict())
                .city(address.getCity())
                .state(address.getState())
                .build();
    }
}
