package br.com.pan.customer.usecase;

import br.com.pan.customer.domain.Customer;
import br.com.pan.customer.usecase.port.SaveCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCustomerUseCase {

    private final SaveCustomerPort saveCustomerPort;

    public Customer save(Customer customer) {
        return saveCustomerPort.save(customer);
    }
}
