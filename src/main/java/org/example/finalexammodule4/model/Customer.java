package org.example.finalexammodule4.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "khach_hang")
@ToString(exclude = "transactions")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cusId;

    @NotEmpty(message = "name not empty")
    private String cusName;

    @NotEmpty(message = "phone not empty")
    private String cusPhone;

    @NotEmpty(message = "email not empty")
    private String cusEmail;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Transaction> transactions;
}
