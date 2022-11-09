package com.aeroparker.api.service;

import com.aeroparker.api.repository.DataAccessRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static com.aeroparker.api.service.ValidationServiceImp.EMAIL_VALIDATION_MESSAGE;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ValidationServiceImpTest {
    @InjectMocks
    private ValidationServiceImp validationServiceImp;

    @Mock
    private DataAccessRepo dataAccessRepo;

    public static final String emailAddress = "test@gmail.com";

    @Test
    void testValidateFormWhenEmailIsAlreadyPresent() {
        when(dataAccessRepo.getByEmailAddress(anyString())).thenReturn(emailAddress);
        Set<String> validationMessages = validationServiceImp.validateData(SampleData.getCustomerVoData());
        Assertions.assertTrue(validationMessages.contains(EMAIL_VALIDATION_MESSAGE));
        verify(dataAccessRepo, times(1)).getByEmailAddress(emailAddress);

    }

    @Test
    void testValidateFormWhenEmailIsNotPresent() {
        when(dataAccessRepo.getByEmailAddress(anyString())).thenReturn(null);
        Set<String> validationMessages = validationServiceImp.validateData(SampleData.getCustomerVoData());
        Assertions.assertFalse(validationMessages.contains(EMAIL_VALIDATION_MESSAGE));
        verify(dataAccessRepo, times(1)).getByEmailAddress(emailAddress);

    }

    @Test
    void testValidateFormWhenFirstNameIsEmpty() {
        when(dataAccessRepo.getByEmailAddress(anyString())).thenReturn(null);
        Set<String> validationMessages = validationServiceImp.validateData(SampleData.getInvalidCustomerData());
        Assertions.assertTrue(validationMessages.contains("First name can not be empty"));
        verify(dataAccessRepo, times(1)).getByEmailAddress(emailAddress);

    }
}