package week6.election.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;


//@Component
//@Aspect
public class LoggingAspect {

    /*@Before(value = "publicMethodsPointCut()")
    public void loggingPublicMethodsAdvice(){
        System.out.println("public method was called");
    }*/

    @Pointcut(value = "execution(public * week6.election.service..*(..))")
    public void publicMethodsPointCut(){}

    @Around(value = "publicMethodsPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
       // String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.printf("before method %s");//, methodName);

        /*try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.printf("after method %s", methodName);*/
        return null;
    }

}
