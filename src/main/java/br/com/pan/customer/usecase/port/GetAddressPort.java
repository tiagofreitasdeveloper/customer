package br.com.pan.customer.usecase.port;

import br.com.pan.customer.domain.Address;

public interface GetAddressPort {

    Address findAddressByPostalCode(String postalCode);
}
