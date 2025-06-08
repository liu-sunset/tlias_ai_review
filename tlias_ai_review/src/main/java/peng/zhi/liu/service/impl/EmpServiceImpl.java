package peng.zhi.liu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import peng.zhi.liu.mapper.EmpExprMapper;
import peng.zhi.liu.mapper.EmpMapper;
import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.EmpExpr;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.EmpQueryParam;
import peng.zhi.liu.service.EmpService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    //分页查询员工
    @Override
    public PageResult<Emp> selectEmpPageService(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        Page<Emp> page =  empMapper.selectEmpPageMapper(empQueryParam);
        return new PageResult<Emp>(page.getTotal(),page.getResult());
    }

    //批量删除员工
    @Override
    public void deleteEmpService(List<Integer> ids) {
        empMapper.deleteEmpMapper(ids);
    }

    //添加员工
    @Override
    //事务管理，指定出现所有异常就会回滚
    @Transactional(rollbackFor = {Exception.class})
    public void addEmpService(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        //插入员工基本信息
        empMapper.addEmpBasicMapper(emp);
        //为员工工作经历信息中的deptId赋值
        if(!CollectionUtils.isEmpty(emp.getExprList())){
            for (EmpExpr empExpr : emp.getExprList()){
                empExpr.setEmpId(emp.getId());
            }
        }
        //插入员工工作经历信息
        empExprMapper.addEmpExprMapper(emp);
    }

    @Override
    //根据ID查询员工
    @Transactional(rollbackFor = {Exception.class})
    public Emp selectEmpByIdService(Integer id) {
        //查询员工的基本信息
        Emp emp =  empMapper.selectEmpByIdMapper(id);
        //查询员工的工作经历信息
       List<EmpExpr>  empExprList = empExprMapper.selectEmpByIdMapper(emp.getId());
       emp.setExprList(empExprList);
       return emp;
    }
}
