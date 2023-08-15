package pl.marcindev.aopdemo.dao;

import pl.marcindev.Account;

import java.util.List;

public interface AccountDAO {
    List<Account>findAccounts();
    List<Account> findAccounts(boolean tripWire);
    void addAccount();
    boolean doWork();
    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);


}
