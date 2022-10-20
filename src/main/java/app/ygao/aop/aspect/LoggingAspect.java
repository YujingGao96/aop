package app.ygao.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(app.ygao.aop.annotation.Loggable)")
    public void loggableMethods(){}

    @Before("loggableMethods()")
    public void log(JoinPoint jp) {
        LOGGER.debug("Running @Before Advice on {}", jp.getSignature());
    }

}
