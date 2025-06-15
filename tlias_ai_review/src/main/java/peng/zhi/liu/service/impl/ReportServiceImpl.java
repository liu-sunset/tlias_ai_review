package peng.zhi.liu.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.mapper.EmpMapper;
import peng.zhi.liu.mapper.OperateLogMapper;
import peng.zhi.liu.mapper.StudentMapper;
import peng.zhi.liu.pojo.ClazzStudentCountData;
import peng.zhi.liu.pojo.EmpJobData;
import peng.zhi.liu.pojo.LogQueryParam;
import peng.zhi.liu.pojo.OperateLog;
import peng.zhi.liu.service.EmpService;
import peng.zhi.liu.service.ReportService;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private OperateLogMapper operateLogMapper;
    //员工性别信息统计
    @Override
    public List<Map<String, Object>> empGenderStatService() {
        return empMapper.empGenderStatMapper();
    }

    //员工职位信息统计
    @Override
    public EmpJobData empDegreeStatService() {
        List<Map<String, Object>> maps = empMapper.empDegreeStatMapper();
        List<Object> name = maps.stream().map(map -> map.get("name")).toList();
        List<Object> value = maps.stream().map(map -> map.get("value")).toList();
        return new EmpJobData(name,value);
    }

    //学员学历信息统计
    @Override
    public List<Map<String, Object>> studentDegreeStatService() {
       return studentMapper.studentDegreeStatMapper();
    }

    //班级人数统计
    @Override
    public ClazzStudentCountData studentCountStatService() {
        List<Map<String, Object>> maps = studentMapper.studentCountStatMapper();
        List<Object> name = maps.stream().map(map -> map.get("name")).toList();
        List<Object> value = maps.stream().map(map -> map.get("value")).toList();
        return new ClazzStudentCountData(name,value);
    }

    //日志列表分页查询
    @Override
    public List<OperateLog> selectLogPageService(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(),logQueryParam.getPageSize());
        return operateLogMapper.selectLogPageMapper();
    }
}
