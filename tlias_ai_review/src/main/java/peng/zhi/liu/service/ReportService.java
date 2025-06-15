package peng.zhi.liu.service;

import peng.zhi.liu.pojo.*;

import java.util.List;
import java.util.Map;

public interface ReportService {
    //员工性别统计
    public List<Map<String, Object>> empGenderStatService();
    //员工职位信息统计
    public EmpJobData empDegreeStatService();
    //学员学历信息统计
    public List<Map<String,Object>> studentDegreeStatService();
    //班级人数统计
    public ClazzStudentCountData studentCountStatService();
    //日志列表分页查询
    public List<OperateLog> selectLogPageService(LogQueryParam logQueryParam);
}
