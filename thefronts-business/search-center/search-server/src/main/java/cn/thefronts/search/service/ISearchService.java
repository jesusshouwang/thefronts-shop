package cn.thefronts.search.service;

import cn.thefronts.common.model.PageResult;
import cn.thefronts.search.model.SearchDto;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * @author chenkun
 * @date 2019/4/24
 */
public interface ISearchService {
    /**
     * StringQuery通用搜索
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     * @return
     */
    PageResult<JsonNode> strQuery(String indexName, SearchDto searchDto) throws IOException;
}
