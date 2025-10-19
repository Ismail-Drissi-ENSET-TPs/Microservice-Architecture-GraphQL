package io.ismaildrissi.microservicearchitecture.services;

import io.ismaildrissi.microservicearchitecture.dtos.CustomerRequestDTO;
import io.ismaildrissi.microservicearchitecture.dtos.CustomerResponseDTO;
import io.ismaildrissi.microservicearchitecture.entities.Customer;
import io.ismaildrissi.microservicearchitecture.mappers.CustomerMapperI;
import io.ismaildrissi.microservicearchitecture.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

    private CustomerRepository customerRepository;
    private CustomerMapperI customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapperI customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        return customerMapper.customerToCustomerResponseDTO(customerRepository.findById(id).orElse(null));
    }

    @Override
    public List<CustomerResponseDTO> getCustomers() {
        return customerRepository.findAll().stream().map(x -> customerMapper.customerToCustomerResponseDTO(x)).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = Customer.builder().id(UUID.randomUUID().toString()).name(customerRequestDTO.getName()).accounts(null).build();
        customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(customer);
    }
}
