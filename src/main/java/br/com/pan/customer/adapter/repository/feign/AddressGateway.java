package br.com.pan.customer.adapter.repository.feign;

import br.com.pan.customer.adapter.repository.feign.dto.AddressDto;
import br.com.pan.customer.domain.Address;
import br.com.pan.customer.adapter.repository.feign.mapper.AddressResponseMapper;
import br.com.pan.customer.usecase.port.GetAddressPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressGateway implements GetAddressPort {

    private final AddressFeign addressFeign;

    public Address findAddressByPostalCode(String postalCode) {
        var addressDto = addressFeign.findAddressByPostalCode(postalCode)
                .orElse(AddressDto.builder().build());
        return AddressResponseMapper.toDomain(addressDto);

    }
}
