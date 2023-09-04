package service;

import com.indium.bankingapp.model.BankAccount;

public interface AccountService {
        boolean addAccount(BankAccount account);
        boolean updateAccount(int id, BankAccount updatedAccount);
        boolean deleteAccount(int id);
        BankAccount getAccountById(int id);
        BankAccount[] getAllAccounts();
    }


