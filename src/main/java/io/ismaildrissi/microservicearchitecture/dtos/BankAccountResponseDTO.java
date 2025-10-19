package io.ismaildrissi.microservicearchitecture.dtos;

import io.ismaildrissi.microservicearchitecture.entities.Customer;
import io.ismaildrissi.microservicearchitecture.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Builder
@Data @AllArgsConstructor
@NoArgsConstructor
@Getter
public class BankAccountResponseDTO {
    private Double balance;
    private String currency;
    private String id;
    private Date createdAt;
    private AccountType accountType;
    private CustomerResponseDTO customer;
}
