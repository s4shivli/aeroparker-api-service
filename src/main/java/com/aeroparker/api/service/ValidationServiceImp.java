package com.aeroparker.api.service;

import com.aeroparker.api.model.CustomersVO;
import com.aeroparker.api.repository.DataBaseAccessJpa;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ValidationServiceImp implements ValidationService{

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    private final DataBaseAccessJpa dataBaseAccessJpa;

    public static final String EMAIL_VALIDATION_MESSAGE = "Email address is present";

    public ValidationServiceImp(DataBaseAccessJpa dataBaseAccessJpa) {
        this.dataBaseAccessJpa = dataBaseAccessJpa;
    }

    public Set<String> validateData(CustomersVO customerVO) {
        Set<String> validationMessages = new HashSet<>();
        String returnEmailAddress = dataBaseAccessJpa.getByEmailAddress(customerVO.getEmailAddress());

        if (returnEmailAddress != null) {
            validationMessages.add(EMAIL_VALIDATION_MESSAGE);
        }
        Set<ConstraintViolation<CustomersVO>> constraintViolations = validator.validate(customerVO);
        Set<String> violationMessages = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
        validationMessages.addAll(violationMessages);
        return validationMessages;

    }


}
