package br.com.pan.customer.adapter.repository.feign.mapper;

import br.com.pan.customer.adapter.repository.feign.dto.AddressDto;
import br.com.pan.customer.domain.Address;

public class AddressResponseMapper {

    public static Address toDomain(AddressDto addressDto) {
        return Address.builder()
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .district(addressDto.getDistrict())
                .state(addressDto.getState())
                .build();
    }
}
