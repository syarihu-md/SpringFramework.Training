package me.syarihu.aspect;

import me.syarihu.models.Product;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Taichi Sato on 15/12/17.
 */
@Aspect
@Component
public class MyFirstAspect {

    @Before("execution(* findProduct(String))")
    public void before() {
        System.out.println("Hello Before! *** メソッドを呼ばれる前に出てくるよ！");
    }

    @After("execution(* findProduct(String))")
    public void after() {
        System.out.println("Hello After! *** メソッドを呼ばれた後に出てくるよ！");
    }

    @AfterReturning(value = "execution(* findProduct(String))", returning = "product")
    public void afterReturning(Product product) {
        System.out.println("Hello AfterReturning! *** メソッドを呼んだ後に出てくるよ！");
    }

    @Around("execution(* findProduct(String))")
    public Product around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Hello Arround! before *** メソッドを呼ぶ前に出てくるよ！");
        Product p = (Product) pjp.proceed();
        System.out.println("Hello Arround! after *** メソッドを呼んだ後に出てくるよ！");
        return p;
    }

    @AfterThrowing(value = "execution(* findProduct(String))", throwing="ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("Hello Throwing! *** 例外になったら出てくるよ");
    }

}
