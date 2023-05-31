package br.com.pan.customer.adapter.repository.jpa.mapper;

import br.com.pan.customer.adapter.repository.jpa.entity.CustomerEntity;
import br.com.pan.customer.domain.Customer;

public class CustomerJpaMapper {

    public static CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .cpf(customer.getCpf())
                .name(customer.getName())
                .birthDate(customer.getBirthDate())
                .address(AddressJpaMapper.toEntity(customer.getAddress()))
                .contact(ContactJpaMapper.toEntity(customer.getContact()))
                .build();
    }

    public static Customer toDomain(CustomerEntity customerEntity) {
        return Customer.builder()
                .cpf(customerEntity.getCpf())
                .name(customerEntity.getName())
                .birthDate(customerEntity.getBirthDate())
                .address(AddressJpaMapper.toDomain(customerEntity.getAddress()))
                .contact(ContactJpaMapper.toDomain(customerEntity.getContact()))
                .build();
    }
}
