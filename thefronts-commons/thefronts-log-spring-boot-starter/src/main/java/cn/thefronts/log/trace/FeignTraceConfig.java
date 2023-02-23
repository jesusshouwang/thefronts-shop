package cn.thefronts.log.trace;

import cn.hutool.core.util.StrUtil;
import cn.thefronts.log.properties.TraceProperties;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * feign拦截器，传递traceId
 *
 * @author chenkun
 * @date 2023/2/20
 */
@Configuration
@ConditionalOnClass(value = {RequestInterceptor.class})
public class FeignTraceConfig {
    @Resource
    private TraceProperties traceProperties;

    @Bean
    public RequestInterceptor feignTraceInterceptor() {
        return template -> {
            if (traceProperties.getEnable()) {
                //传递日志traceId
                String traceId = MDCTraceUtils.getTraceId();
                if (StrUtil.isNotEmpty(traceId)) {
                    template.header(MDCTraceUtils.TRACE_ID_HEADER, traceId);
                    template.header(MDCTraceUtils.SPAN_ID_HEADER, MDCTraceUtils.getNextSpanId());
                }
            }
        };
    }
}
