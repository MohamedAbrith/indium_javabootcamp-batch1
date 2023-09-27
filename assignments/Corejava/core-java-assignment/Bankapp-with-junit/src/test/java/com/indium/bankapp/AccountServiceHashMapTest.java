package com.indium.bankapp;

import com.indium.bankapp.Dao.AccountDao;
import com.indium.bankapp.Model.Account;
import com.indium.bankapp.Service.AccountServiceHashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class AccountServiceHashMapTest {
    @Mock
    private AccountDao accountDao;
    private AccountServiceHashMap accountService;
    @Before
    public void setUp() {
        accountDao = mock(AccountDao.class);
        accountService = new AccountServiceHashMap();
    }
    @Test
    public void createAccount() {
        Account account = new Account(5,"AJITH", 20000,"savings");
        accountService.createAccount(account);
        assertEquals(2, accountService.accountIdCounter); // Assuming it starts at 1
    }

    @Test
    public void getAllAccounts() {
        Account[] allAccounts = accountService.getAllAccounts();
        for (Account account : allAccounts) {
            System.out.println("Retrieved Account: " + account.getId() + ", " + account.getName() + ", " + account.getBalance() + ", " + account.getType());
        }
    }
    @Test
    public void getAccountById() {
        Account account = new Account(1000,"abrith", 20000,"savings");
        Account result = accountService.getAccountById(1);
    }
    @Test
    public void updateBalance() {
        Account account = new Account(20,"KUMAR", 20000,"savings");
        accountService.updateBalance(account, 1500);
        assertEquals(1500, account.getBalance());
    }
}
