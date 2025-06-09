package peng.zhi.liu.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.EmpExpr;
import peng.zhi.liu.pojo.EmpQueryParam;

import java.util.List;

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
}
