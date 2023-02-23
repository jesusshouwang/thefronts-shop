package cn.thefronts.search.client.feign.fallback;

import cn.thefronts.common.model.PageResult;
import cn.thefronts.search.client.feign.SearchService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * searchService降级工场
 *
 * @author chenkun
 */
@Slf4j
public class SearchServiceFallbackFactory implements FallbackFactory<SearchService> {
    @Override
    public SearchService create(Throwable throwable) {
        return (indexName, searchDto) -> {
            log.error("通过索引{}搜索异常:{}", indexName, throwable);
            return PageResult.<JsonNode>builder().build();
        };
    }
}
