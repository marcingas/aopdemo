package pl.marcindev.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + "MEmbership DAO:  doing my db work: adding an account");
    }
}
