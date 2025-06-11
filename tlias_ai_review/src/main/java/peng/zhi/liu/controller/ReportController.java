package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peng.zhi.liu.pojo.ClazzStudentCountData;
import peng.zhi.liu.pojo.EmpJobData;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.service.ReportService;

import java.lang.invoke.CallSite;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    //员工性别统计
    @GetMapping("/empGenderData")
    public Result empGenderStatController(){
        log.info("统计员工性别信息");
        List<Map<String, Object>> maps = reportService.empGenderStatService();
        return Result.success(maps);
    }

    //统计员工职位信息
    @GetMapping("/empJobData")
    public Result empDegreeStatController(){
        log.info("员工职位信息统计");
        EmpJobData empJobData = reportService.empDegreeStatService();
        return Result.success(empJobData);
    }

    //统计学员学历信息
    @GetMapping("/studentDegreeData")
    public Result studentDegreeStatController(){
        log.info("学员学历信息统计");
        List<Map<String,Object>> maps = reportService.studentDegreeStatService();
        return Result.success(maps);
    }

    //班级人数统计
    @GetMapping("/studentCountData")
    public Result studentCountStatController(){
        log.info("班级人数统计");
        ClazzStudentCountData clazzStudentCountData = reportService.studentCountStatService();
        return Result.success(clazzStudentCountData);
    }
}
