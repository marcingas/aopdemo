package pl.marcindev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
    @Pointcut("execution(* pl.marcindev.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* pl.marcindev.aopdemo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* pl.marcindev.aopdemo.dao.*.set*(..))")
    private void setter() {}
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("Executing before method add Account<===");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("Performing API analytics<==========");
    }
}
