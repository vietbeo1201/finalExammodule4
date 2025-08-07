package org.example.finalexammodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "khach_hang")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cusId;
    private String CusName;
    private String cusPhone;
    private String cusEmail;
}