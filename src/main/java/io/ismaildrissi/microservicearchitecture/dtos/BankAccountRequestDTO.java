package io.ismaildrissi.microservicearchitecture.dtos;

import io.ismaildrissi.microservicearchitecture.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.data.geo.CustomMetric;

@Builder
@Data @AllArgsConstructor
@NoArgsConstructor
@Getter
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType accountType;
    private CustomerRequestDTO customer;
}
