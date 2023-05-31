package br.com.pan.customer.adapter.repository.jpa.mapper;

import br.com.pan.customer.adapter.repository.jpa.entity.AddressEntity;
import br.com.pan.customer.domain.Address;

public class AddressJpaMapper {

    public static AddressEntity toEntity(Address address) {
        return AddressEntity.builder()
                .postalCode(address.getPostalCode())
                .number(address.getNumber())
                .complement(address.getComplement())
                .street(address.getStreet())
                .district(address.getDistrict())
                .city(address.getCity())
                .state(address.getState())
                .build();
    }

    public static Address toDomain(AddressEntity addressEntity) {
        return Address.builder()
                .postalCode(addressEntity.getPostalCode())
                .number(addressEntity.getNumber())
                .complement(addressEntity.getComplement())
                .street(addressEntity.getStreet())
                .district(addressEntity.getDistrict())
                .city(addressEntity.getCity())
                .state(addressEntity.getState())
                .build();
    }
}
