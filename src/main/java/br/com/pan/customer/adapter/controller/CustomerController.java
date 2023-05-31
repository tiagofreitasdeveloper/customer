package br.com.pan.customer.adapter.controller;

import br.com.pan.customer.adapter.controller.dto.CustomerDto;
import br.com.pan.customer.adapter.controller.mapper.CustomerDtoMapper;
import br.com.pan.customer.adapter.controller.response.CustomerResponse;
import br.com.pan.customer.usecase.GetCustomerUseCase;
import br.com.pan.customer.usecase.SaveCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final SaveCustomerUseCase saveCustomerUseCase;

    private final GetCustomerUseCase getCustomerUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse saveCustomer(@RequestBody CustomerDto customerDto) {
        var customerToSave = CustomerDtoMapper.toDomain(customerDto);
        var customer = saveCustomerUseCase.save(customerToSave);

        return CustomerDtoMapper.toResponse(customer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getCustomer(@RequestParam(value = "cpf")  String cpf) {
        var customer = getCustomerUseCase.getCustomerByCpf(cpf);

        return CustomerDtoMapper.toResponse(customer);
    }
}
