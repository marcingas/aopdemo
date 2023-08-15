package pl.marcindev.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.marcindev.Account;
import pl.marcindev.aopdemo.dao.AccountDAO;
import pl.marcindev.aopdemo.dao.MembershipDAO;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
//			demoBeforeAdvice(accountDAO, membershipDAO);
//			demoAfterReturningAdvice(accountDAO);
            demoAfterThrowingAdvice(accountDAO);


        };
    }

    private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("...caught exception: " + exc);
        }
        System.out.println("Main program: demoAfterThrowingAdvice ");
        System.out.println(accounts);
    }

    private void demoAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("displaying accounts: ");
        System.out.println(accounts);
    }

    private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        accountDAO.addAccount();
        membershipDAO.addAccount();

    }

}
