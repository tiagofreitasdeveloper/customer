package br.com.pan.customer.adapter.repository.kafka.mapper;

import br.com.pan.customer.domain.Contact;

public class ContactKafkaMapper {

    public static String toAvro(Contact contact) {
        return contact.getPhone();
    }
}
