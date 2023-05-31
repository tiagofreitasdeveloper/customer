package br.com.pan.customer.adapter.repository.jpa;

import br.com.pan.customer.adapter.repository.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByCpf(String cpf);
}
