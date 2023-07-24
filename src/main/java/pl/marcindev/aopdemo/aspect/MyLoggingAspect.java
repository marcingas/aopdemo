package pl.marcindev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
@Before("execution(public void pl.marcindev.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
    System.out.println("Executing before method add Account<===");
}
}
