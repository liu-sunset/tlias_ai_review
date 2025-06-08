package peng.zhi.liu.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peng.zhi.liu.pojo.Dept;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.service.DeptService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    //查询所有部门
    @GetMapping
    public Result selectAllDeptController(){
    log.info("查询所有部门");
    List<Dept> deptList =  deptService.selectAllDeptService();
    return Result.success(deptList);
    }

    //删除部门
    @DeleteMapping
    public Result deleteDeptByIdController(Integer id){
        log.info("删除部门的id是：{}",id);
        deptService.deleteDeptByIdService(id);
        return Result.success();
    }

    //添加部门
    @PostMapping
    public Result addDeptController(@RequestBody Dept dept){
        log.info("添加部门:{}",dept.getName());
        deptService.addDeptService(dept);
        return Result.success();
    }

    //根据ID查询部门
    @GetMapping("/{id}")
    public Result selectByIdController(@PathVariable Integer id){
        log.info("查询部门ID:{}",id);
        Dept dept = deptService.selectByIdService(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping
    public Result modifyDeptController(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        deptService.modifyDeptService(dept);
        return Result.success();
    }
}
