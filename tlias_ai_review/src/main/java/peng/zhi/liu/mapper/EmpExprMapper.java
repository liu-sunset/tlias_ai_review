package peng.zhi.liu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    //添加员工工作经历信息
    public void addEmpExprMapper(Emp emp);
    //根据ID查询员工的工作经历信息
    public List<EmpExpr> selectEmpByIdMapper(Integer empId);
}
