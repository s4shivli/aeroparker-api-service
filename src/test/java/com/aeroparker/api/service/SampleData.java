package com.aeroparker.api.service;

import com.aeroparker.api.entity.Customers;
import com.aeroparker.api.model.CustomersVO;

import java.time.LocalDateTime;

public class SampleData {
    public static final String EMPTY_FIRST_NAME_FIELD = "First name can not be empty";

    public static CustomersVO getCustomerVoData() {
        return CustomersVO.builder()
                .emailAddress("test@gmail.com")
                .firstName("Shivli")
                .lastName("Lastname")
                .title("Ms")
                .city("London")
                .addressLine1(" 23 GantsHill")
                .postCode("re3 43r")
                .build();
    }

    public static CustomersVO getInvalidCustomerData() {
        return CustomersVO.builder()
                .emailAddress("test@gmail.com")
                .firstName(null)
                .lastName("")
                .title("Ms")
                .city("London")
                .addressLine1(" 23 GantsHill")
                .postCode(null)
                .build();
    }

    public static Customers getCustomerData() {
        return Customers.builder()
                .city("london")
                .id(1)
                .title("miss")
                .first_name("fName")
                .last_name("lName")
                .email_address("fname@email.com")
                .phone_number("43565653")
                .post_code("we3 re3")
                .address_line_1("line 1")
                .address_line_2("line2")
                .registered(LocalDateTime.now())
                .build();
    }
}
