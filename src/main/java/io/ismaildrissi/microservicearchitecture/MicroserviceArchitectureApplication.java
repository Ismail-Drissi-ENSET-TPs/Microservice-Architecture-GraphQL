package io.ismaildrissi.microservicearchitecture;

import io.ismaildrissi.microservicearchitecture.entities.BankAccount;
import io.ismaildrissi.microservicearchitecture.entities.Customer;
import io.ismaildrissi.microservicearchitecture.enums.AccountType;
import io.ismaildrissi.microservicearchitecture.repositories.BankAccountRepository;
import io.ismaildrissi.microservicearchitecture.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroserviceArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceArchitectureApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {

        Stream.of("Aziz", "Mohammed", "Amina").forEach(name -> {
            Customer customer = Customer.builder().id(UUID.randomUUID().toString()).name(name).build();
            customerRepository.save(customer);
            for (int i = 0; i<5; i++){
                BankAccount bankAccount = BankAccount.builder().id(UUID.randomUUID().toString()).accountType(Math.random()>0.5?
                        AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT).createdAt(new Date()).customer(customer).balance(Math.random()).currency("MAD").build();
                bankAccountRepository.save(bankAccount);
            }
        });




        return args -> {

        };
    }

}

