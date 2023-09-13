package Service;
import Model.Account;
import java.util.Map;
import java.util.List;
public interface BankOperation {
    void createAccount(Account account);
    Account[] getAllAccounts();
    Account getAccountById(int id);
    void updateBalance(Account account, int newBalance);
    void deleteAccount(int id);
    int countAccountsAboveOneLac();
    Map<String, Integer> countAccountsByType();
    Map<String, Integer>countAndSortAccountsByType();
    Map<String, Integer> calculateAvgBalanceByType();
    List<Integer> getAccountIdsByName(String name);
}
