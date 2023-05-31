package br.com.pan.customer.adapter.controller.mapper;

import br.com.pan.customer.domain.Contact;

public class ContactDtoMapper {

    public static Contact toDomain(String phone) {
        return Contact.builder()
                .phone(phone)
                .build();
    }

    public static String toResponse(Contact contact) {
        return contact.getPhone();
    }
}
