package io.ismaildrissi.microservicearchitecture.services;

import io.ismaildrissi.microservicearchitecture.dtos.BankAccountRequestDTO;
import io.ismaildrissi.microservicearchitecture.dtos.BankAccountResponseDTO;
import io.ismaildrissi.microservicearchitecture.entities.BankAccount;

import java.util.List;

public interface BankAccountServiceI {
    public BankAccountResponseDTO createBankAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO getBankAccountById(String id);
    public List<BankAccountResponseDTO> getAllBankAccounts();
    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountDTO);
    public void deleteBankAccount(String id);

    }
