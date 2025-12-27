package io.ismaildrissi.microservicearchitecture.entities;

import io.ismaildrissi.microservicearchitecture.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {BankAccount.class}, name = "p1")
public interface AccountProject {
    public String getId();
    public AccountType getAccountType();
    public Double getBalance();
}

