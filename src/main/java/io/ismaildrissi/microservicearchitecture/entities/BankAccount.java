package io.ismaildrissi.microservicearchitecture.entities;

import io.ismaildrissi.microservicearchitecture.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
}
