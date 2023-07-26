package pl.marcindev.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.marcindev.aopdemo.dao.AccountDAO;
import pl.marcindev.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner->{
			demoBeforeAdvice(accountDAO, membershipDAO);
			accountDAO.setName("account A");
			accountDAO.setServiceCode("service A");

			String name = accountDAO.getName();
			String code = accountDAO.getServiceCode();





		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
	accountDAO.addAccount();
	membershipDAO.addAccount();

	}

}
