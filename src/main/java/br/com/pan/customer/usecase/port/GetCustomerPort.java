package br.com.pan.customer.usecase.port;

import br.com.pan.customer.domain.Customer;

public interface GetCustomerPort {

    Customer findByCpf(String cpf);
}
