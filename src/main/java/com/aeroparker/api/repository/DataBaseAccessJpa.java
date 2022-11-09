package com.aeroparker.api.repository;

import com.aeroparker.api.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataBaseAccessJpa extends JpaRepository<Customers, Integer> {

    @Query("SELECT email_address FROM Customers WHERE LOWER(email_address) = LOWER(?1)")
    String getByEmailAddress(String emailId);
}
