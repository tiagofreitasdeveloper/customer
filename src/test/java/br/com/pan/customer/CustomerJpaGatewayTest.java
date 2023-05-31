package br.com.pan.customer;

import br.com.pan.customer.adapter.repository.CustomerGateway;
import br.com.pan.customer.adapter.repository.jpa.CustomerJpaRepository;
import br.com.pan.customer.domain.Address;
import br.com.pan.customer.domain.Contact;
import br.com.pan.customer.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class CustomerJpaGatewayTest {

    @InjectMocks
    private CustomerGateway customerJpaGateway;

    @Mock
    private CustomerJpaRepository customerRepository;

    @Test
    void givenCustomerRequestThenConfirmThatStateOfCustomerNotChanged() {

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
}
