package br.com.pan.customer.adapter.repository.jpa.mapper;

import br.com.pan.customer.adapter.repository.jpa.entity.AddressEntity;
import br.com.pan.customer.adapter.repository.jpa.entity.ContactEntity;
import br.com.pan.customer.adapter.repository.jpa.entity.CustomerEntity;
import br.com.pan.customer.domain.Address;
import br.com.pan.customer.domain.Contact;
import br.com.pan.customer.domain.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerJpaMapperTest {

    @Test
    void givenCustomerDomainThenConvertCustomerEntity() {
        var customer = buildCustomer();
        var address = customer.getAddress();
        var contact = customer.getContact();

        var customerEntity = CustomerJpaMapper.toEntity(customer);
        var addressEntity = AddressJpaMapper.toEntity(address);
        var contactEntity = ContactJpaMapper.toEntity(contact);

        assertThat(customer.getName()).isEqualTo(customerEntity.getName());
        assertThat(customer.getCpf()).isEqualTo(customerEntity.getCpf());
        assertThat(customer.getBirthDate()).isEqualTo(customerEntity.getBirthDate());
        assertThat(address.getPostalCode()).isEqualTo(addressEntity.getPostalCode());
        assertThat(address.getNumber()).isEqualTo(addressEntity.getNumber());
        assertThat(address.getComplement()).isEqualTo(addressEntity.getComplement());
        assertThat(address.getStreet()).isEqualTo(addressEntity.getStreet());
        assertThat(address.getDistrict()).isEqualTo(addressEntity.getDistrict());
        assertThat(address.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(address.getState()).isEqualTo(addressEntity.getState());
        assertThat(contact.getPhone()).isEqualTo(contactEntity.getPhone());
    }

    @Test
    void givenCustomerEntityThenConvertCustomerDomain() {
        var customerEntity = buildCustomerEntity();
        var addressEntity = customerEntity.getAddress();
        var contactEntity = customerEntity.getContact();

        var customer = CustomerJpaMapper.toDomain(customerEntity);
        var address = AddressJpaMapper.toDomain(addressEntity);
        var contact = ContactJpaMapper.toDomain(contactEntity);

        assertThat(customer.getName()).isEqualTo(customerEntity.getName());
        assertThat(customer.getCpf()).isEqualTo(customerEntity.getCpf());
        assertThat(customer.getBirthDate()).isEqualTo(customerEntity.getBirthDate());
        assertThat(address.getPostalCode()).isEqualTo(addressEntity.getPostalCode());
        assertThat(address.getNumber()).isEqualTo(addressEntity.getNumber());
        assertThat(address.getComplement()).isEqualTo(addressEntity.getComplement());
        assertThat(address.getStreet()).isEqualTo(addressEntity.getStreet());
        assertThat(address.getDistrict()).isEqualTo(addressEntity.getDistrict());
        assertThat(address.getCity()).isEqualTo(addressEntity.getCity());
        assertThat(address.getState()).isEqualTo(addressEntity.getState());
        assertThat(contact.getPhone()).isEqualTo(contactEntity.getPhone());
    }

    private Customer buildCustomer() {
        return Customer.builder()
                .cpf("34739071894")
                .name("Tiago Freitas")
                .birthDate(LocalDate.of(1984, 04, 29))
                .contact(buildContact())
                .address(buildAddress())
                .build();
    }

    private Address buildAddress() {
        return Address.builder()
                .postalCode("09614000")
                .street("Avenida Winston Churchill")
                .number("1477")
                .complement("Bloco 1, apto 13")
                .district("Rudge Ramos")
                .city("Sao Bernardo")
                .state("SP")
                .build();
    }

    private Contact buildContact() {
        return Contact.builder()
                .phone("974230509")
                .build();
    }

    private CustomerEntity buildCustomerEntity() {
        return CustomerEntity.builder()
                .cpf("34739071894")
                .name("Tiago Freitas")
                .birthDate(LocalDate.of(1984, 04, 29))
                .contact(buildContactEntity())
                .address(buildAddressEntity())
                .build();
    }

    private AddressEntity buildAddressEntity() {
        return AddressEntity.builder()
                .postalCode("09614000")
                .street("Avenida Winston Churchill")
                .number("1477")
                .complement("Bloco 1, apto 13")
                .district("Rudge Ramos")
                .city("Sao Bernardo")
                .state("SP")
                .build();
    }

    private ContactEntity buildContactEntity() {
        return ContactEntity.builder()
                .phone("974230509")
                .build();
    }
}
