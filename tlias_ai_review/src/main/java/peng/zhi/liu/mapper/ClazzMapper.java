package peng.zhi.liu.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.service.ClazzService;
import peng.zhi.liu.service.impl.ClazzServiceImpl;

import java.util.List;

@Mapper
public interface ClazzMapper {
    //分页查询
    public Page<Clazz> selectClazzPageMapper(ClazzQueryParam clazzQueryParam);
    //删除班级
    public void deleteClazzMapper(Integer id);
    //添加班级
    public void addClazzMapper(Clazz clazz);
    //根据ID查询班级
    public Clazz selectClazzByIdMapper(Integer id);
    //修改班级信息
    public void modifyClazzMapper(Clazz clazz);
    //查询所有班级
    public List<Clazz> selectAllClazzMapper();
}
