package service;

import com.indium.bankingapp.model.BankAccount;

public class AccountServiceArrayImplementation implements AccountService {
    private BankAccount[] accounts;
    private int numAccounts;
    private static final int INITIAL_CAPACITY = 10;
    public AccountServiceArrayImplementation() {
        accounts = new BankAccount[INITIAL_CAPACITY];
        numAccounts = 0;
    }
    @Override
    public boolean addAccount(BankAccount account) {
        if (numAccounts == accounts.length) {
            resizeArray();
        }
        accounts[numAccounts] = account;
        numAccounts++;
        return true;
    }
    @Override
    public boolean updateAccount(int id, BankAccount updatedAccount) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getId() == id) {
                accounts[i] = updatedAccount;
                return true;
            }
        }
        return false; // Account not found.
    }

    @Override
    public boolean deleteAccount(int id) {
        int indexToRemove = -1;
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getId() == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {

            for (int i = indexToRemove; i < numAccounts - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            numAccounts--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BankAccount getAccountById(int id) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getId() == id) {
                return accounts[i];
            }
        }
        return null;
    }
    @Override
    public BankAccount[] getAllAccounts() {
        BankAccount[] validAccounts = new BankAccount[numAccounts];
        System.arraycopy(accounts, 0, validAccounts, 0, numAccounts);
        return validAccounts;
    }
    private void resizeArray() {
        int newCapacity = accounts.length * 2;
        BankAccount[] newAccounts = new BankAccount[newCapacity];
        System.arraycopy(accounts, 0, newAccounts, 0, numAccounts);
        accounts = newAccounts;
    }
}
