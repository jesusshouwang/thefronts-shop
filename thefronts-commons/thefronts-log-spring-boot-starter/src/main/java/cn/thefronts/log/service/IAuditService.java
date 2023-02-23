package cn.thefronts.log.service;

import cn.thefronts.log.model.Audit;

/**
 * 审计日志接口
 *
 * @author chenkun
 * @date 2023/2/20
 */
public interface IAuditService {
    void save(Audit audit);
}
