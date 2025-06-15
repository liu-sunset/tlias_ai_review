package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peng.zhi.liu.anno.OperateLog;
import peng.zhi.liu.pojo.*;
import peng.zhi.liu.service.EmpService;

import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //分页查询员工
    @GetMapping
    public Result selectEmpPageController(EmpQueryParam empQueryParam){
       log.info("分页查询参数：{}", empQueryParam);
        PageResult<Emp> pageResult =  empService.selectEmpPageService(empQueryParam);
        return Result.success(pageResult);
    }

    //批量员工删除
    @DeleteMapping
    @OperateLog
    public Result deleteEmpController(@RequestParam List<Integer> ids){
        log.info("批量删除员工：{}",ids);
        empService.deleteEmpService(ids);
        return Result.success();
    }

    //添加员工
    @PostMapping
    @OperateLog
    public Result addEmpController(@RequestBody Emp emp){
        log.info("添加员工：{}",emp);
        empService.addEmpService(emp);
        return Result.success();
    }

    //根据ID查询员工
    @GetMapping("/{id}")
    public Result selectEmpByIdController(@PathVariable Integer id){
        log.info("根据ID查询回显:{}",id);
        Emp emp =  empService.selectEmpByIdService(id);
        return Result.success(emp);
    }

    //修改员工信息
    @PutMapping
    @OperateLog
    public Result updateEmpController(@RequestBody Emp emp){
        log.info("修改员工信息：{}",emp);
        empService.updateEmpService(emp);
        return Result.success();
    }
}
