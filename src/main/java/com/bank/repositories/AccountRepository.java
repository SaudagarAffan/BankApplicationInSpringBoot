package com.bank.repositories;

import com.bank.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> 
{
    Optional<Account> findByAccountNumber(String accountNumber);
}
