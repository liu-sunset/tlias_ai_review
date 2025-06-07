package peng.zhi.liu.service;

import org.springframework.stereotype.Service;
import peng.zhi.liu.pojo.Dept;

import java.util.List;


public interface DeptService {
    //查询所有部门
    public List<Dept> selectAllDeptService();
    //删除部门
    public void deleteDeptByIdService(Integer id);
}
