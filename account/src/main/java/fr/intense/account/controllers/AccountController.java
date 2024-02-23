package fr.intense.account.controllers;

import fr.intense.account.entities.Account;
import fr.intense.account.models.Customer;
import fr.intense.account.proxies.CustomerProxy;
import fr.intense.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    AccountRepository accountRepository;
    CustomerProxy customerProxy;

    //générer controller
    @Autowired
    public AccountController(AccountRepository accountRepository, CustomerProxy customerProxy) {
        this.accountRepository = accountRepository;
        this.customerProxy = customerProxy;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        List <Account> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
           Customer customer= customerProxy.getCustomerById(account.getCustomerId());
           account.setCustomer(customer);
        });
        return accountList;
    }


    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable String id) {

        Account account= accountRepository.findById(id).orElse(null);
        if(account==null)
            return null;
        Customer customer= customerProxy.getCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }




}
