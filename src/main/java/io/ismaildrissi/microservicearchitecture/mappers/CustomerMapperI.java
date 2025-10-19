package io.ismaildrissi.microservicearchitecture.mappers;


import io.ismaildrissi.microservicearchitecture.dtos.CustomerRequestDTO;
import io.ismaildrissi.microservicearchitecture.dtos.CustomerResponseDTO;
import io.ismaildrissi.microservicearchitecture.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface CustomerMapperI {

    CustomerResponseDTO customerToCustomerResponseDTO (Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);

}
