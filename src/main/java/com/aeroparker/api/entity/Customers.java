package com.aeroparker.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime registered;

    @Column(length = 255, unique = true,nullable = false)
    private String email_address;

    @Column(length = 5,nullable = false)
    private String title;

    @Column(length = 50,nullable = false)
    private String first_name;

    @Column(length = 50,nullable = false)
    private String last_name;

    @Column(length = 255,nullable = false)
    private String address_line_1;

    @Column(length = 255)
    private String address_line_2;

    @Column(length = 255)
    private String city;

    @Column(length = 10,nullable = false)
    private String post_code;

    @Column(length = 20)
    private String phone_number;
}
