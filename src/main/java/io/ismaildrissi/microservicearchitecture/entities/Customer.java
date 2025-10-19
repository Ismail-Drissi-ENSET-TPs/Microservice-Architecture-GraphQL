package io.ismaildrissi.microservicearchitecture.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Customer {

    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "customer")
    private List<BankAccount> accounts;


}
