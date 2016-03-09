package hello;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
public class LogAspect {
	static Logger logger = Logger.getLogger(LogAspect.class);	

	
	@Pointcut("execution(* hello.GreetingController.getContent(..))")
	public void execTime() {};
	
	@Pointcut("execution(* hello.GreetingController.maxPriority(..))")
	public void execTimeForMaxPriority() {};
	
	@Around("execTime()")
	public void calcExecTime(ProceedingJoinPoint jp){
		if(logger.isDebugEnabled())
			logger.info("getContent() execution started at:	"+System.currentTimeMillis());
			Long startTime=System.currentTimeMillis();
		
			try {
				jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			if(logger.isDebugEnabled())
				logger.info("getContent() execution ended at:	"+System.currentTimeMillis());
			Long endtime=System.currentTimeMillis();
			logger.info("Time taken to execute getContent() method:	"+ (endtime-startTime));
			
		}
		
	
	@Before("execTimeForMaxPriority()")
	public void initialTime() {
		if(logger.isDebugEnabled())
			logger.info("MaxPriorty() execution started at:	"+System.currentTimeMillis());
		
	}

	@AfterReturning("execTimeForMaxPriority()")
	public void finalTime() {
		if(logger.isDebugEnabled())
			logger.info("MaxPriorty() execution ended at:	"+System.currentTimeMillis());
			
	}
}
	
	
	

