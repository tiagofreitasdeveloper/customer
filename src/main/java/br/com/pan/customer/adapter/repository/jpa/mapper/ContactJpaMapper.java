package br.com.pan.customer.adapter.repository.jpa.mapper;

import br.com.pan.customer.domain.Contact;
import br.com.pan.customer.adapter.repository.jpa.entity.ContactEntity;

public class ContactJpaMapper {

    public static ContactEntity toEntity(Contact contact) {
        return ContactEntity.builder()
                .phone(contact.getPhone())
                .build();
    }

    public static Contact toDomain(ContactEntity contactEntity) {
        return Contact.builder()
                .phone(contactEntity.getPhone())
                .build();
    }
}
