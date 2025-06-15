package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import peng.zhi.liu.pojo.LogQueryParam;
import peng.zhi.liu.pojo.OperateLog;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.service.ReportService;

import java.util.List;

@Slf4j
@RestController
public class LogController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/log/page")
    public Result selectlogPageController(LogQueryParam logQueryParam){
        log.info("日志列表分页查询:{}",logQueryParam);
        List<OperateLog> operateLogList = reportService.selectLogPageService(logQueryParam);
        return Result.success(operateLogList);
    }
}
