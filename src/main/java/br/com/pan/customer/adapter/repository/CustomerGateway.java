package br.com.pan.customer.adapter.repository;

import br.com.pan.customer.adapter.repository.feign.AddressFeign;
import br.com.pan.customer.adapter.repository.feign.dto.AddressDto;
import br.com.pan.customer.adapter.repository.feign.mapper.AddressResponseMapper;
import br.com.pan.customer.adapter.repository.jpa.CustomerRepository;
import br.com.pan.customer.adapter.repository.jpa.mapper.CustomerJpaMapper;
import br.com.pan.customer.adapter.repository.kafka.CustomerProducer;
import br.com.pan.customer.adapter.repository.kafka.mapper.CustomerKafkaMapper;
import br.com.pan.customer.domain.Address;
import br.com.pan.customer.domain.Customer;
import br.com.pan.customer.usecase.port.GetCustomerPort;
import br.com.pan.customer.usecase.port.SaveCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerGateway implements SaveCustomerPort, GetCustomerPort {

    private final CustomerRepository customerRepository;

    private final CustomerProducer customerProducer;

    private final AddressFeign addressFeign;

    public Customer save(Customer customer) {
        var customerWithAddress = buildCustomerWithAddress(customer);
        var customerEntity = CustomerJpaMapper.toEntity(customerWithAddress);
         try {
             var customerSaved = customerRepository.save(customerEntity);
             sendCustomer(customerWithAddress);

             return customerSaved;
         } catch (DataIntegrityViolationException dataIntegrityViolationException) {
             throw new DataIntegrityViolationException("Já existe um cliente com este cpf");
         }
    }

    private void sendCustomer(Customer customer) {
        var customerAvro = CustomerKafkaMapper.toAvro(customer);
        customerProducer.sendMessage(customerAvro);
    }

    private Address findAddressByPostalCode(String postalCode) {
        var addressDto = addressFeign.findAddressByPostalCode(postalCode)
                .orElse(AddressDto.builder().build());
        return AddressResponseMapper.toDomain(addressDto);

    }

    private Customer buildCustomerWithAddress(Customer customer) {
       return customer.toBuilder()
               .address(buildAddress(customer.getAddress()))
               .build();
    }

    public Address buildAddress(Address address) {
        var complementAddress = findAddressByPostalCode(address.getPostalCode());

        return complementAddress.toBuilder()
                .postalCode(address.getPostalCode())
                .number(address.getNumber())
                .complement(address.getComplement())
                .build();
    }

    public Customer findByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
}
