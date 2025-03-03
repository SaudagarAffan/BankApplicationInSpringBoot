package com.bank.repositories;

import com.bank.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> 
{
    //  Fixed method name: Use accountNumber instead of accountId
    List<Transaction> findByAccountNumber(String accountNumber);
}
