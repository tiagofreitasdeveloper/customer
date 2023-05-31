package br.com.pan.customer.adapter.repository.kafka.mapper;

import br.com.customer.kafka.avro.AddressAvro;
import br.com.pan.customer.domain.Address;

public class AddressKafkaMapper {

    public static AddressAvro toAvro(Address address) {
        var addressAvro = new AddressAvro();
        addressAvro.setStreet(address.getStreet());
        addressAvro.setNumber(address.getNumber());
        addressAvro.setComplement(address.getComplement());
        addressAvro.setZip(address.getPostalCode());
        addressAvro.setCity(address.getCity());
        addressAvro.setStateProv(address.getState());

        return addressAvro;
    }
}
