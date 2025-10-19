package io.ismaildrissi.microservicearchitecture.repositories;

import io.ismaildrissi.microservicearchitecture.entities.BankAccount;
import io.ismaildrissi.microservicearchitecture.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
