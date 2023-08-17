package pl.marcindev.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.marcindev.Account;
import pl.marcindev.aopdemo.dao.AccountDAO;
import pl.marcindev.aopdemo.dao.MembershipDAO;
import pl.marcindev.aopdemo.service.TrafficFortuneService;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        System.out.println("running...");
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
                                               MembershipDAO membershipDAO,
                                               TrafficFortuneService trafficFortuneService) {
        return runner -> {
//			demoBeforeAdvice(accountDAO, membershipDAO);
//			demoAfterReturningAdvice(accountDAO);
//            demoAfterThrowingAdvice(accountDAO);
//            demoAfterAdvice(accountDAO);
//            demoAroundAdvice(trafficFortuneService);
demoAroundAdviceHandleException(trafficFortuneService);
        };
    }

    private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("Main program: demoAroundAdviceHandleException");
        System.out.println("calling getFortune()");
        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("My fortune is " + data);
    }

    private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("Main program: demoAroundAdvice");
        System.out.println("calling getFortune()");
        String data = trafficFortuneService.getFortune();
        System.out.println("My fortune is " + data);
    }

    private void demoAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception exc) {
            System.out.println("...caught exception: " + exc);
        }
        System.out.println("Main program: demoAfterAdvice ");
        System.out.println(accounts);
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
