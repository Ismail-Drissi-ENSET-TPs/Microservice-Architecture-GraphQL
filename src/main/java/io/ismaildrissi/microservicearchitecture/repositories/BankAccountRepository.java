package io.ismaildrissi.microservicearchitecture.repositories;

import io.ismaildrissi.microservicearchitecture.entities.BankAccount;
import io.ismaildrissi.microservicearchitecture.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> getBankAccountsById(String id);

    BankAccount getBankAccountById(String id);

    @RestResource(path="/byType")
    List<BankAccount> findBankAccountByAccountType(@Param("t") AccountType accountType);

    BankAccount findBankAccountById(String id);
}
