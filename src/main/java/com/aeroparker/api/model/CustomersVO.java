package com.aeroparker.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
public class CustomersVO {
    @Email(message = "Email is not valid")
    @Size(max = 255, message = "Email length exceeded")
    private String emailAddress;

    @Size(max = 5, message = "Title length exceeded")
    @NotEmpty(message = "Title can not be empty")

    private String title;
    @Size(max = 50, message = "First name length exceeded")
    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @Size(max = 50, message = "Last name length exceeded")
    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @Size(max = 255, message = "Address length exceeded")
    @NotEmpty(message = "AddressLine1 name can not be empty")
    private String addressLine1;

    @Size(max = 255, message = "AddressLine2 length exceeded")
    private String addressLine2;

    @Size(max = 255, message = "city length exceeded")
    private String city;

    @Size(max = 10, message = "postCode length exceeded")
    @NotEmpty(message = "PostCode can not be empty")
    private String postCode;

    @Size(max = 20, message = "phoneNumber length exceeded")
    private String phoneNumber;
}
