package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.service.ClazzService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    //分页查询
    @GetMapping
    public Result selectClazzPageController(ClazzQueryParam clazzQueryParam){
        log.info("分页查询：{}",clazzQueryParam);
        PageResult<Clazz> pageResult =  clazzService.selectClazzPageService(clazzQueryParam);
        return Result.success(pageResult);
    }

    //删除班级
    @DeleteMapping("/{id}")
    public Result deleteClazzController(@PathVariable Integer id){
        log.info("删除班级：{}",id);
        clazzService.deleteClazzService(id);
        return Result.success();
    }

    //添加班级
    @PostMapping
    public Result addClazzController(@RequestBody Clazz clazz){
        log.info("添加班级：{}",clazz);
        clazzService.addClazzService(clazz);
        return Result.success();
    }

    //根据ID查询
    @GetMapping("/{id}")
    public Result selectClazzByIdController(@PathVariable Integer id){
        log.info("根据ID查询班级:{}",id);
        Clazz clazz = clazzService.selectClazzByIdService(id);
        return Result.success(clazz);
    }

    //修改班级
    @PutMapping
    public Result modifyClazzController(@RequestBody Clazz clazz){
        log.info("修改班级:{}",clazz);
        clazzService.modifyClazzService(clazz);
        return Result.success();
    }

    //查询所有班级
    @GetMapping("/list")
    public Result  selectAllClazzController(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.selectAllClazzService();
        return Result.success(clazzList);
    }
}
