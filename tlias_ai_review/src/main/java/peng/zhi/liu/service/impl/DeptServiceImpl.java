package peng.zhi.liu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.mapper.DeptMapper;
import peng.zhi.liu.pojo.Dept;
import peng.zhi.liu.service.DeptService;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selectAllDeptService() {
        return deptMapper.selectAllDeptMapper();
    }

    @Override
    public void deleteDeptByIdService(Integer id) {
        deptMapper.deleteByIdMapper(id);
    }
}
