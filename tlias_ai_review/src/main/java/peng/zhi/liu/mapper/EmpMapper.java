package peng.zhi.liu.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.EmpExpr;
import peng.zhi.liu.pojo.EmpQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    //分页查询员工
    public Page<Emp> selectEmpPageMapper(EmpQueryParam empQueryParam);
    //批量删除员工
    public void deleteEmpMapper(List<Integer> ids);
    //添加员工基本信息
    public void addEmpBasicMapper(Emp emp);
    //根据ID查询员工的基本信息
    public Emp selectEmpByIdMapper(Integer id);
    //修改员工基本信息
    public void updateEmpBasicMapper(Emp emp);
    //统计员工性别
    @MapKey("name")//没什么用,为了解决误报
    public List<Map<String,Object>> empGenderStatMapper();
    //统计员工职位信息
    @MapKey(("name"))
    public List<Map<String, Object>> empDegreeStatMapper();
}
