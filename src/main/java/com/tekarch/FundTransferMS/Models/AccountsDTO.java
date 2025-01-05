package com.tekarch.FundTransferMS.Models;

import lombok.Data;

import java.time.LocalDateTime;



@Data
public class AccountsDTO {


    private Long accountId;
    private String accountNumber;// VARCHAR(20) UNIQUE, NOT NULL
    private String accountType;
    private String currency; // VARCHAR(10) with default value 'USD'
    private Double balance; // DECIMAL(15,2) with default value 0.0
}