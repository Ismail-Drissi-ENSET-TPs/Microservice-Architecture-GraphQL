package io.ismaildrissi.microservicearchitecture.mappers;

import io.ismaildrissi.microservicearchitecture.dtos.BankAccountResponseDTO;
import io.ismaildrissi.microservicearchitecture.entities.BankAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapperI {

    BankAccountResponseDTO bankAccountToBankAccountResponseDTO (BankAccount bankAccount);

}
