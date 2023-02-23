package cn.thefronts.oauth.service;

import cn.thefronts.common.model.PageResult;
import cn.thefronts.oauth.model.TokenVo;

import java.util.Map;

/**
 * @author thefronts
 * @date 2023/2/22
 */
public interface ITokensService {
    /**
     * 查询token列表
     * @param params 请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
