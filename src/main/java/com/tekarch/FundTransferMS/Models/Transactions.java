package com.tekarch.FundTransferMS.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transfer_id")
    private Long transfer_id;
    @NonNull
    private Long sender_account_id;
    @NonNull
    private Long reciever_account_id;
    @NonNull
    private Double amount;
    private String status;
    @CreationTimestamp
    private LocalDateTime initiated_at;
    @Column
    @UpdateTimestamp
    private LocalDateTime completed_at;

}
