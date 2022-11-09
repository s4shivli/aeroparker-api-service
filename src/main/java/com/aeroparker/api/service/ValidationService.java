package com.aeroparker.api.service;

import com.aeroparker.api.model.CustomersVO;

import java.util.Set;

public interface ValidationService {
    Set<String> validateData(CustomersVO customerVO);
}
