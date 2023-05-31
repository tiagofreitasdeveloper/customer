package br.com.pan.customer.adapter.controller.mapper;

import br.com.pan.customer.adapter.controller.response.CustomerResponse;
import br.com.pan.customer.domain.Customer;
import br.com.pan.customer.adapter.controller.dto.CustomerDto;

public class CustomerDtoMapper {

    public static Customer toDomain(CustomerDto customerDto) {
        return Customer.builder()
                .cpf(customerDto.getCpf())
                .name(customerDto.getName())
                .birthDate(customerDto.getBirthDate())
                .contact(ContactDtoMapper.toDomain(customerDto.getPhone()))
                .address(AddressDtoMapper.toDomain(customerDto.getAddress()))
                .build();
    }

    public static CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder()
                .cpf(customer.getCpf())
                .name(customer.getName())
                .birthDate(customer.getBirthDate())
                .phone(ContactDtoMapper.toResponse(customer.getContact()))
                .address(AddressDtoMapper.toResponse(customer.getAddress()))
                .build();
    }
}
