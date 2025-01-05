package com.tekarch.FundTransferMS.Repository;

import com.tekarch.FundTransferMS.Models.Transactions;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long> {
}
