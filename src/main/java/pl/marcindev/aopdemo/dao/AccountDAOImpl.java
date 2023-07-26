package pl.marcindev.aopdemo.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository

public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

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
