package com.salesforce.smallstore;

import com.salesforce.smallstore.model.Account;
import com.salesforce.smallstore.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class AccountTests {

    private final AccountService service;

    @Autowired
    public AccountTests(AccountService service) {
        this.service = service;
    }

    @Test
    void addAccount() {
        String name = "FPT";
        Account account = Account.builder().name(name).build();
        account = service.addAccount(account);
        Assertions.assertEquals(name, account.getName());
    }

    @Test
    @Transactional
    void getAccount() {
        String uuid = "2c9380817cfd85e9017cfd85f02c0000";
        String name = "FPT";
        Account account = service.getAccountByUuid(uuid);
        Assertions.assertEquals(name, account.getName());
    }

    @Test
    void getAllAccounts() {
        List<Account> accounts = service.getAll();
        Assertions.assertEquals(3, accounts.size());
    }

}
