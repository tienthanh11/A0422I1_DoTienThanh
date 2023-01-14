package com.codegym.demo_spring_security.repository;

import com.codegym.demo_spring_security.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByAccountName(String accountName);
}
