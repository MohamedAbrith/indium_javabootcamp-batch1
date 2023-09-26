package com.indium.bankapp.Dao;

import com.indium.bankapp.Model.Account;

import java.util.List;

public interface AccountDao {
    public Boolean create(Account account);
    public Boolean update(Account account);
    public boolean delete(int id);
    public Account get(int id);

    public List<Account> getall();
}

