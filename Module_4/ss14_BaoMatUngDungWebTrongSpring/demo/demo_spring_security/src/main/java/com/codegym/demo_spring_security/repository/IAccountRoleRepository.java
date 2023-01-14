package com.codegym.demo_spring_security.repository;

import com.codegym.demo_spring_security.model.AccountRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRoleRepository extends CrudRepository<AccountRole, Long> {
    @Query("select ar.role.roleName from AccountRole ar where ar.account.accountName = :accountName")
    List<String> findAllRoleByUser(String accountName);
}
