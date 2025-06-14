package peng.zhi.liu.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//表明注解使用的地方
@Retention(RetentionPolicy.RUNTIME)//表明什么时候生效
public @interface OperateLog {
}
