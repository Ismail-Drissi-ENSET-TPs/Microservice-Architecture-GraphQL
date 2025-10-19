package io.ismaildrissi.microservicearchitecture.services;

import io.ismaildrissi.microservicearchitecture.dtos.BankAccountRequestDTO;
import io.ismaildrissi.microservicearchitecture.dtos.BankAccountResponseDTO;
import io.ismaildrissi.microservicearchitecture.entities.BankAccount;
import io.ismaildrissi.microservicearchitecture.entities.Customer;
import io.ismaildrissi.microservicearchitecture.mappers.BankAccountMapperI;
import io.ismaildrissi.microservicearchitecture.mappers.CustomerMapperI;
import io.ismaildrissi.microservicearchitecture.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountService implements BankAccountServiceI {

    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapperI bankAccountMapperI;
    private final CustomerMapperI customerMapperI;

    public BankAccountService(BankAccountRepository bankAccountRepository, BankAccountMapperI bankAccountMapperI, CustomerMapperI customerMapperI) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapperI = bankAccountMapperI;
        this.customerMapperI = customerMapperI;
    }

    public BankAccountResponseDTO createBankAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder().id(UUID.randomUUID().toString())
                .accountType(bankAccountDTO.getAccountType())
                .balance(bankAccountDTO.getBalance())
                .createdAt(new Date())
                .currency(bankAccountDTO.getCurrency())
                .customer(customerMapperI.customerRequestDTOToCustomer(bankAccountDTO.getCustomer()))
                .build();
        this.bankAccountRepository.save(bankAccount);
        return bankAccountMapperI.bankAccountToBankAccountResponseDTO(bankAccount);
    }

    public BankAccountResponseDTO getBankAccountById(String id) {
        return bankAccountMapperI.bankAccountToBankAccountResponseDTO(this.bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Bank account not found")));
    }

    public List<BankAccountResponseDTO> getAllBankAccounts() {
        List<BankAccount> bankAccounts = this.bankAccountRepository.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOS = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapperI.bankAccountToBankAccountResponseDTO(bankAccount);
            bankAccountResponseDTO.setCustomer(customerMapperI.customerToCustomerResponseDTO(bankAccount.getCustomer()));
            bankAccountResponseDTOS.add(bankAccountResponseDTO);
        }
        return bankAccountResponseDTOS;
    }

    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = this.bankAccountRepository.findBankAccountById(id);
        if (bankAccount.getBalance() != null) bankAccount.setBalance(bankAccountDTO.getBalance());
        if (bankAccount.getCurrency() != null)  bankAccount.setCurrency(bankAccountDTO.getCurrency());
        if (bankAccount.getAccountType() != null)  bankAccount.setAccountType(bankAccountDTO.getAccountType());
        return bankAccountMapperI.bankAccountToBankAccountResponseDTO(bankAccountRepository.save(bankAccount));
    }

    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

}
