package cn.thefronts.file.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.thefronts.db.mapper.SuperMapper;
import cn.thefronts.file.model.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 上传存储db
 *
 * @author chenkun
 */
@Mapper
public interface FileMapper extends SuperMapper<FileInfo> {
    List<FileInfo> findList(Page<FileInfo> page, @Param("f") Map<String, Object> params);
}
