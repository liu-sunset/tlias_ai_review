package peng.zhi.liu.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import peng.zhi.liu.mapper.OperateLogMapper;
import peng.zhi.liu.pojo.OperateLog;
import peng.zhi.liu.utils.CurrentHolder;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class OperateLogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("@annotation(peng.zhi.liu.anno.OperateLog)")
    public Object logOperate(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long costTime = end-begin;
        //构建日志实体
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(object !=null ? object.toString() : "void");
        operateLog.setCostTime(costTime);
        operateLog.setOperateEmpId(getEmpId());
        log.info("记录日志：{}",operateLog);
        operateLogMapper.addOperateLogMapper(operateLog);
        return object;
    }

    public Integer getEmpId(){
        return CurrentHolder.getCurrentLocal();
    }
}
