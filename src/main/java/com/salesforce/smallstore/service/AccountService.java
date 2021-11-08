package com.salesforce.smallstore.service;

import com.salesforce.smallstore.model.Account;
import com.salesforce.smallstore.model.Order;

import java.util.List;


public interface AccountService {

    List<Order> getAllOrdersForAccount(String uuid);

    Account getAccountByOrderUuid(String orderUuid);

    List<Account> getAll();

    Account getAccountByUuid(String uuid);

    Account addAccount(Account account);
}
