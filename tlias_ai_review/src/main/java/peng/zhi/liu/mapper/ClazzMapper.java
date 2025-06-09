package peng.zhi.liu.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.service.impl.ClazzServiceImpl;

@Mapper
public interface ClazzMapper {
    //分页查询
    public Page<Clazz> selectClazzPageMapper(ClazzQueryParam clazzQueryParam);
}
