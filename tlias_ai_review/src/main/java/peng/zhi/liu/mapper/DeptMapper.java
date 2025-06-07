package peng.zhi.liu.mapper;

import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.pojo.Dept;
import java.util.List;


@Mapper
public interface DeptMapper {
    //查询所有部门
    public List<Dept> selectAllDeptMapper();
    //删除部门
    public void deleteByIdMapper(Integer id);
}
