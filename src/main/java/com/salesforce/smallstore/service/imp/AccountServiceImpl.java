package com.salesforce.smallstore.service.imp;

import com.salesforce.smallstore.model.Account;
import com.salesforce.smallstore.model.Order;
import com.salesforce.smallstore.repository.AccountRepository;
import com.salesforce.smallstore.repository.OrderRepository;
import com.salesforce.smallstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, OrderRepository orderRepository) {
        this.accountRepository = accountRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrdersForAccount(String uuid) {
        return orderRepository.getAllByAccountUuid(uuid);
    }

    @Override
    public Account getAccountByOrderUuid(String orderUuid) {
        Optional<Order> order = orderRepository.findById(orderUuid);
        return order.map(Order::getAccount).orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }


    @Override
    public Account getAccountByUuid(String uuid) {
        return accountRepository.getById(uuid);
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }
}
