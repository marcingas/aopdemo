package pl.marcindev.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class MyAppAopExpressions {

    @Pointcut("execution(* pl.marcindev.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* pl.marcindev.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* pl.marcindev.aopdemo.dao.*.set*(..))")
    public void setter() {}
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
