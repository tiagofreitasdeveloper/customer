package br.com.pan.customer.usecase;

import br.com.pan.customer.domain.Customer;
import br.com.pan.customer.usecase.port.GetCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCustomerUseCase {

    private final GetCustomerPort getCustomerPort;

    public Customer getCustomerByCpf(String cpf) {
        return getCustomerPort.findByCpf(cpf);
    }
}
