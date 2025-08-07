package org.example.finalexammodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "giao_dich")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transId")
    private long transId;
    @ManyToOne
    @JoinColumn(name = "cusId")
    private Customer customer;
    private String transDate;      // dd/mm/yyyy
    private String transType;
    private double transPrice;
    private double transArea;       // VND/m2
}
