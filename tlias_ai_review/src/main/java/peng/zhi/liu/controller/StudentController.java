package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peng.zhi.liu.mapper.StudentMapper;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.pojo.Student;
import peng.zhi.liu.pojo.StudentQueryParam;
import peng.zhi.liu.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //分页查询
    @GetMapping
    public Result selectStudentPageController(StudentQueryParam studentQueryParam){
        log.info("分页查询:{}",studentQueryParam);
        PageResult<Student> pageResult = studentService.selectStudentPageService(studentQueryParam);
        return Result.success(pageResult);
    }

    //批量删除学员
    @DeleteMapping("/{ids}")
    public Result deleteStudentController(@PathVariable List<Integer> ids){
        log.info("批量删除学员：{}",ids);
        studentService.deleteStudentService(ids);
        return Result.success();
    }

    //添加学员
    @PostMapping
    public Result addStudentController(@RequestBody Student student){
        log.info("添加学员：{}",student);
        studentService.addStudentService(student);
        return Result.success();
    }

    //根据ID查询学员
    @GetMapping("/{id}")
    public Result selectStudentByIdController(@PathVariable Integer id){
        log.info("根据ID查询学员:{}",id);
        Student student = studentService.selectstudentByIdService(id);
        return Result.success(student);
    }

    //修改学员信息
    @PutMapping
    public Result modifyStudentController(@RequestBody Student student){
        log.info("修改学员信息:{}",student);
        studentService.modifyStudentService(student);
        return Result.success();
    }

    //学员违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result violationStudentController(@PathVariable Integer id,@PathVariable Integer score){
        studentService.violationStudentService(id,score);
        return Result.success();
    }
}
