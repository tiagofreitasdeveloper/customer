package br.com.pan.customer.adapter.repository.feign;

import br.com.pan.customer.adapter.repository.feign.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "addressClient", url = "https://viacep.com.br/ws")
public interface AddressFeign {

    @GetMapping(value = "/{cep}/json")
    Optional<AddressDto> findAddressByPostalCode(@PathVariable("cep") String postalCode);
}
