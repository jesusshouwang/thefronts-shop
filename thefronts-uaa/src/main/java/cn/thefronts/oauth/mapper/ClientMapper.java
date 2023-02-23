package cn.thefronts.oauth.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.thefronts.db.mapper.SuperMapper;
import cn.thefronts.oauth.model.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author thefronts
 * @date 2023/2/22
 */
@Mapper
public interface ClientMapper extends SuperMapper<Client> {
    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params );
}
