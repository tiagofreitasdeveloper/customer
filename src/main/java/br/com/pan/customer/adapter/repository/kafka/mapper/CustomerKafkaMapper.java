package br.com.pan.customer.adapter.repository.kafka.mapper;

import br.com.customer.kafka.avro.CustomerAvro;
import br.com.pan.customer.domain.Customer;

public class CustomerKafkaMapper {

    public static CustomerAvro toAvro(Customer customer) {
        var customerAvro = new CustomerAvro();
        customerAvro.setName(customer.getName());
        customerAvro.setCpf(customer.getCpf());
        customerAvro.setBirthDate(String.valueOf(customer.getBirthDate()));
        customerAvro.setPhone(ContactKafkaMapper.toAvro(customer.getContact()));
        customerAvro.setAddressAvro(AddressKafkaMapper.toAvro(customer.getAddress()));

        return customerAvro;
    }

}
