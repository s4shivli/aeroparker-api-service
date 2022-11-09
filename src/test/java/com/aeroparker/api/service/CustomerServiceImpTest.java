package com.aeroparker.api.service;

import com.aeroparker.api.entity.Customers;
import com.aeroparker.api.exception.AeroParkerException;
import com.aeroparker.api.model.CustomersVO;
import com.aeroparker.api.repository.DataAccessRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Set;

import static com.aeroparker.api.service.CustomerServiceImp.SUCCESSFUL;
import static com.aeroparker.api.service.SampleData.EMPTY_FIRST_NAME_FIELD;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImpTest {

    @InjectMocks
    private CustomerServiceImp customerServiceImp;

    @Mock
    private DataAccessRepo dataAccessRepo;

    @Mock
    private ValidationServiceImp validationService;

    private CustomersVO getSampleCustomerVOData() {
        return CustomersVO.builder()
                .firstName("Shivli")
                .lastName("Biswas")
                .addressLine1("flat-2")
                .addressLine2("MyAvenue")
                .city("NewCastle")
                .postCode("XYZ 30Y")
                .build();
    }

    @Test
    void testCustomersAddedSuccessfully() {
        when(validationService.validateData(getSampleCustomerVOData())).thenReturn(Collections.emptySet());
        when(dataAccessRepo.save(any(Customers.class))).thenReturn(SampleData.getCustomerData());
        String response = customerServiceImp.addCustomer(getSampleCustomerVOData());
        Assertions.assertEquals(SUCCESSFUL, response);
        verify(dataAccessRepo, times(1)).save(any(Customers.class));
    }

    @Test
    void testCustomerDataFailToAddDueToUnknownDBIssue() {
        when(validationService.validateData(getSampleCustomerVOData())).thenReturn(Collections.emptySet());
        doThrow(new RuntimeException("some error has occurred")).when(dataAccessRepo).save(any(Customers.class));
        Assertions.assertThrows(RuntimeException.class, () -> customerServiceImp.addCustomer(getSampleCustomerVOData()));
    }

    @Test
    void testWhenCustomerDataInvalidThenThrowInvalidDataException() {
        when(validationService.validateData(getSampleCustomerVOData())).thenReturn(Collections.emptySet());
        doThrow(new RuntimeException("some error has occurred")).when(dataAccessRepo).save(any(Customers.class));
        Assertions.assertThrows(RuntimeException.class, () -> customerServiceImp.addCustomer(getSampleCustomerVOData()));
    }

    @Test
    void testWhenCustomerDataFirstNameIsEmpty() {
        when(validationService.validateData(SampleData.getInvalidCustomerData())).thenReturn(Set.of(EMPTY_FIRST_NAME_FIELD));
        Assertions.assertThrows(AeroParkerException.class, () -> customerServiceImp.addCustomer(SampleData.getInvalidCustomerData()));
    }


}