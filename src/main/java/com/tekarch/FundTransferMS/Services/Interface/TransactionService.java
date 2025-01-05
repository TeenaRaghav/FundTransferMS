package com.tekarch.FundTransferMS.Services.Interface;

import com.tekarch.FundTransferMS.Models.Transactions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
    Transactions transferFunds(Transactions fundTransfer);
    List<Transactions> getAllTransactions();
    Optional<Transactions> getTransactionById(Long transactionId);
}
