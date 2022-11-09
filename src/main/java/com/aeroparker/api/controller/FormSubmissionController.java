package com.aeroparker.api.controller;

import com.aeroparker.api.model.CustomersVO;
import com.aeroparker.api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/registration")
public class FormSubmissionController {

    private final CustomerService customerService;

    @PostMapping
    public String addCustomerToDb(@RequestBody CustomersVO customersVO) {
        return customerService.addCustomer(customersVO);
    }
}
