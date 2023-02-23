package cn.thefronts.oauth.service;

import cn.thefronts.common.model.PageResult;
import cn.thefronts.common.model.Result;
import cn.thefronts.common.service.ISuperService;
import cn.thefronts.oauth.model.Client;

import java.util.Map;

/**
 * @author thefronts
 * @date 2023/2/22
 */
public interface IClientService extends ISuperService<Client> {
    Result saveClient(Client clientDto) throws Exception;

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClient(Map<String, Object> params, boolean isPage);

    void delClient(long id);

    Client loadClientByClientId(String clientId);
}
