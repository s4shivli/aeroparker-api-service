package com.aeroparker.api.controller;

import com.aeroparker.api.exception.AeroParkerException;
import com.aeroparker.api.model.CustomersVO;
import com.aeroparker.api.service.CustomerService;
import com.aeroparker.api.service.SampleData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormSubmissionController.class)
class FormSubmissionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;

    @Test
    void testWhenControllerResponseSuccessfully() throws Exception {
        this.mockMvc
                .perform(
                        post("/registration")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(sampleJson)

                )
                .andExpect(status().isOk());
    }

    @Test
    void testWhenControllerResponseUnSuccessful() throws Exception {
        this.mockMvc
                .perform(
                        post("/registration")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("")

                )
                .andExpect(status().isInternalServerError());
    }
    @Test
    void testWhenControllerIsResponseBadRequest() throws Exception {

        Set<String> validationMessage= Set.of("First name can not be Empty");

        when(customerService.addCustomer(any(CustomersVO.class))).thenThrow(new AeroParkerException(validationMessage));
        this.mockMvc
                .perform
                        (post("/registration")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(sampleJso2n)
                        ).andExpect(status().isBadRequest());
    }



    private final static String sampleJson = "{\"emailAddress\":\"lhamma24@gmail.com\",\n" +
            "\"title\":\"Mrs\",\n" +
            "\"firstName\":\"shamma\",\n" +
            "\"lastName\":\"Xolxo\",\n" +
            "\"addressLine1\":\" 24 wellington road\",\n" +
            "\"addressLine2\":\"\",\n" +
            "\"city\":\"\",\n" +
            "\"postCode\":\"sx12 4ty\",\n" +
            "\"phoneNumber\":\"\"\n" +
            "}";
    private final static String sampleJso2n = "{\"emailAddress\":\"lhamma24@gmail.com\",\n" +
            "\"title\":\"Mrs\",\n" +
            "\"firstName\":\"\",\n" +
            "\"lastName\":\"Xolxo\",\n" +
            "\"addressLine1\":\" 24 wellington road\",\n" +
            "\"addressLine2\":\"\",\n" +
            "\"city\":\"\",\n" +
            "\"postCode\":\"sx12 4ty\",\n" +
            "\"phoneNumber\":\"\"\n" +
            "}";
}