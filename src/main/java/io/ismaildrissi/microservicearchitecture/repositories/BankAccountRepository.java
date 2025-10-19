package io.ismaildrissi.microservicearchitecture.repositories;

import io.ismaildrissi.microservicearchitecture.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> getBankAccountsById(String id);

    BankAccount getBankAccountById(String id);

    BankAccount findBankAccountById(String id);
}
