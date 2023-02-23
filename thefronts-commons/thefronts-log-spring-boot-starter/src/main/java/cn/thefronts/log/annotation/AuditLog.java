package cn.thefronts.log.annotation;

import java.lang.annotation.*;

/**
 * 审计日志
 *
 * @author chenkun
 * @date 2023/2/20
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {
    /**
     * 操作信息
     */
    String operation();
}
