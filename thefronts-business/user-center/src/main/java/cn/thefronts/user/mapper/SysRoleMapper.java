package cn.thefronts.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.thefronts.common.model.SysRole;
import cn.thefronts.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author zlt
 * 角色
 */
@Mapper
public interface SysRoleMapper extends SuperMapper<SysRole> {
	List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);

	List<SysRole> findAll();
}
