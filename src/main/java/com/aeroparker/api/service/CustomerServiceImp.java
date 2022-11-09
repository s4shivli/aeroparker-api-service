package com.aeroparker.api.service;

import com.aeroparker.api.entity.Customers;
import com.aeroparker.api.exception.AeroParkerException;
import com.aeroparker.api.model.CustomersVO;
import com.aeroparker.api.repository.DataBaseAccessJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@Slf4j
public class CustomerServiceImp implements CustomerService {
    private final DataBaseAccessJpa dataBaseAccessJpa;
    private final ValidationService validationService;
    public static final String SUCCESSFUL = "Form submitted successfully";

    CustomerServiceImp(DataBaseAccessJpa dataBaseAccessJpa, ValidationServiceImp validationService) {
        this.dataBaseAccessJpa = dataBaseAccessJpa;
        this.validationService = validationService;
    }

    private Customers convertCustomerVOToCustomersDbEntity(CustomersVO customer) {
        return Customers.builder()
                .email_address(customer.getEmailAddress())
                .title(customer.getTitle())
                .first_name(customer.getFirstName())
                .last_name(customer.getLastName())
                .address_line_1(customer.getAddressLine1())
                .address_line_2(customer.getAddressLine2())
                .city(customer.getCity())
                .post_code(customer.getPostCode())
                .phone_number(customer.getPhoneNumber())
                .registered(LocalDateTime.now())
                .build();

    }

    @Override
    public String addCustomer(CustomersVO customerVO) {
        Set<String> validationMessage = validationService.validateData(customerVO);
        if (!validationMessage.isEmpty()) {
            throw new AeroParkerException(validationMessage);
        }

        Customers customer = convertCustomerVOToCustomersDbEntity(customerVO);
        try {
            dataBaseAccessJpa.save(customer);
            return SUCCESSFUL;
        } catch (Exception exception) {
            log.error("Error in adding customer data ", exception);
            throw new RuntimeException("Fail to store in dataBase");
        }


    }
}

