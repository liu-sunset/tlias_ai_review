package peng.zhi.liu.service;

import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.EmpExpr;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.EmpQueryParam;

import java.util.List;

public interface EmpService {
    //分页查询
    public PageResult<Emp> selectEmpPageService(EmpQueryParam empQueryParam);
    //批量删除员工
    public void deleteEmpService(List<Integer> ids);
    //添加员工
    public void addEmpService(Emp emp);
    //根据ID查询员工
    public Emp selectEmpByIdService(Integer id);
}
