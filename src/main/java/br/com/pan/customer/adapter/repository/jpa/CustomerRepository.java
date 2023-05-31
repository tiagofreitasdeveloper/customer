package br.com.pan.customer.adapter.repository.jpa;

import br.com.pan.customer.adapter.repository.jpa.entity.CustomerEntity;
import br.com.pan.customer.adapter.repository.jpa.mapper.CustomerJpaMapper;
import br.com.pan.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;

    public Customer save(CustomerEntity customerEntity) {
        try {
            var customerSaved = customerJpaRepository.save(customerEntity);

            return CustomerJpaMapper.toDomain(customerSaved);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DataIntegrityViolationException("Já existe um cliente com este cpf");
        }
    }

    public Customer findByCpf(String cpf) {
        var customerEntity = customerJpaRepository.findByCpf(cpf)
                .orElseThrow(EntityNotFoundException::new);
        return CustomerJpaMapper.toDomain(customerEntity);
    }
}