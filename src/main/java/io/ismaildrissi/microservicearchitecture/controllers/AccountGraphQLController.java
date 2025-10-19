package io.ismaildrissi.microservicearchitecture.controllers;

import io.ismaildrissi.microservicearchitecture.dtos.BankAccountRequestDTO;
import io.ismaildrissi.microservicearchitecture.dtos.BankAccountResponseDTO;
import io.ismaildrissi.microservicearchitecture.dtos.CustomerRequestDTO;
import io.ismaildrissi.microservicearchitecture.dtos.CustomerResponseDTO;
import io.ismaildrissi.microservicearchitecture.services.BankAccountServiceI;
import io.ismaildrissi.microservicearchitecture.services.CustomerServiceI;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQLController {

    private BankAccountServiceI bankAccountService;
    private CustomerServiceI customerService;

    public AccountGraphQLController(BankAccountServiceI bankAccountService, CustomerServiceI customerService) {
        this.bankAccountService = bankAccountService;
        this.customerService = customerService;
    }

    @QueryMapping
    public List<BankAccountResponseDTO> accountsList() {
        return bankAccountService.getAllBankAccounts();
    }

    @QueryMapping
    public BankAccountResponseDTO bankAccountById(@Argument String id) {
        return bankAccountService.getBankAccountById(id);
    }

    @QueryMapping
    public CustomerResponseDTO customerById(@Argument String id) {
        return customerService.getCustomer(id);
    }

    @QueryMapping
    public List<CustomerResponseDTO> customers() {
        return customerService.getCustomers();
    }

    @MutationMapping
    public CustomerResponseDTO createCustomer(@Argument CustomerRequestDTO customerRequestDTO) {
        return customerService.createCustomer(customerRequestDTO);
    }

    @MutationMapping
    public BankAccountResponseDTO createBankAccount(@Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.createBankAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.updateBankAccount(id, bankAccountRequestDTO);
    }

    @MutationMapping
    public void deleteBankAccount(@Argument String id) {
        bankAccountService.deleteBankAccount(id);
    }


}
