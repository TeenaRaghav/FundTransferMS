package com.tekarch.FundTransferMS.Services;

import com.tekarch.FundTransferMS.Models.AccountsDTO;
import com.tekarch.FundTransferMS.Models.Transactions;
import com.tekarch.FundTransferMS.Repository.TransactionRepository;
import com.tekarch.FundTransferMS.Services.Interface.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
   @Autowired
   private TransactionRepository transactionRepository;

   @Autowired
   private RestTemplate restTemplate;

   String url = "http://localhost:8080/accounts";

    @Override
    public Transactions transferFunds(Transactions fundTransfer) {
       AccountsDTO recieverAccounts = restTemplate.getForObject(url + "/" + fundTransfer.getReciever_account_id(),
               AccountsDTO.class);
        AccountsDTO senderAccounts = restTemplate.getForObject(url + "/" + fundTransfer.getSender_account_id(),
                AccountsDTO.class);
            if(recieverAccounts.getAccountNumber() == null || senderAccounts.getAccountNumber() == null){
                throw new RuntimeException("Invalid Account");
            }

            recieverAccounts.setBalance(recieverAccounts.getBalance() + fundTransfer.getAmount());
            senderAccounts.setBalance(senderAccounts.getBalance() - fundTransfer.getAmount());

            restTemplate.put(url, senderAccounts);
            restTemplate.put(url, recieverAccounts);

        return transactionRepository.save(fundTransfer);
    }

    @Override
    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transactions> getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId);
    }
}
