package pl.marcindev.aopdemo.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import pl.marcindev.Account;

import java.util.ArrayList;
import java.util.List;

@Repository

public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) throw new RuntimeException("Sorry, You shall not pass!!");

        List<Account> myAccounts = new ArrayList<>();
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Luca", "Platinum");
        Account temp3 = new Account("John", "Gold");
        myAccounts.add(temp2);
        myAccounts.add(temp1);
        myAccounts.add(temp3);

        return myAccounts;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass() + " doing my db work: adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": do Work");
        return false;
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("getServieCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setServiceCode");
        this.serviceCode = serviceCode;
    }
}
