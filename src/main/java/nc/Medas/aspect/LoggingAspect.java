package nc.Medas.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @After("execution(* nc.Medas.repo.*.*(..))")
    public void after (JoinPoint joinPoint) {
            log.info("after execution of ", joinPoint);

    }
}
