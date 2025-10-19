package io.ismaildrissi.microservicearchitecture.services;

import io.ismaildrissi.microservicearchitecture.dtos.CustomerRequestDTO;
import io.ismaildrissi.microservicearchitecture.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerServiceI {

    CustomerResponseDTO getCustomer(String id);
    List<CustomerResponseDTO> getCustomers();
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

}
