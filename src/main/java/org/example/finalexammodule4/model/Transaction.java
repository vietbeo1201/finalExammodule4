package org.example.finalexammodule4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "giao_dich")
@ToString(exclude = "customer")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transId;

    @ManyToOne
    @JoinColumn(name = "cusId")
    @JsonBackReference
    private Customer customer;

    @Future(message = "Ngày giao dịch phải lớn hơn hoặc là ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate transDate;

    @NotEmpty
    private String transType;

    @Min(value = 500000, message = "Giá trị phải lớn hơn hoặc bằng 500.000")
    private double transPrice;

    @Min(value = 20, message = "Giá trị phải lớn hơn hoặc bằng 20")
    private double transArea;

    @Transient
    public String getTransactionCode() {
        return String.format("MGD-%04d", transId);
    }
}
