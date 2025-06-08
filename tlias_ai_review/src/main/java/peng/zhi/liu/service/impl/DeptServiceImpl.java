package peng.zhi.liu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.mapper.DeptMapper;
import peng.zhi.liu.pojo.Dept;
import peng.zhi.liu.service.DeptService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    //查询所有部门
    @Override
    public List<Dept> selectAllDeptService() {
        return deptMapper.selectAllDeptMapper();
    }

    //根据ID删除部门
    @Override
    public void deleteDeptByIdService(Integer id) {
        deptMapper.deleteByIdMapper(id);
    }

    //添加部门
    @Override
    public void addDeptService(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDeptMapper(dept);
    }

    //根据ID查询部门信息
    @Override
    public Dept selectByIdService(Integer id) {
        return deptMapper.selectByIdMapper(id);
    }

    //修改部门
    @Override
    public void modifyDeptService(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.modifyDeptMapper(dept);
    }
}
