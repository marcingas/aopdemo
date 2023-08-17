package pl.marcindev.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.marcindev.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
    @Around("execution(* pl.marcindev.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("Ececuting around method: " + method);
        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = "No worry, we will handle for You !";

        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("duration is: " + duration / 1000.0 + " seconds");
        return result;
    }

    @After("execution(* pl.marcindev.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> executing @After on method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* pl.marcindev.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountAdvice(
            JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> executing @AfterThrowing on method: " + method);
        System.out.println("===> exception is: " + exc);

    }

    @AfterReturning(
            pointcut = "execution(* pl.marcindev.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> executing @AfterRunning on method: " + method);
        System.out.println("===> result is: " + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("===> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

    @Before("pl.marcindev.aopdemo.aspect.MyAppAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("Executing before method add Account<===");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) System.out.println(tempArg);

    }

}
