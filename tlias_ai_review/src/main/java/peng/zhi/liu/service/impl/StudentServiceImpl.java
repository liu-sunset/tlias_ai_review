package peng.zhi.liu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peng.zhi.liu.mapper.StudentMapper;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.Student;
import peng.zhi.liu.pojo.StudentQueryParam;
import peng.zhi.liu.service.StudentService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    //分页查询
    @Override
    public PageResult<Student> selectStudentPageService(StudentQueryParam studentQueryParam) {
        //开启分页查询
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        Page<Student> page = studentMapper.selectStudentPageMapper(studentQueryParam);
        return new PageResult<>(page.getTotal(),page.getResult());
    }

    //批量删除学员
    @Override
    public void deleteStudentService(List<Integer> ids) {
        studentMapper.deleteStudentMapper(ids);
    }

    //添加学员
    @Override
    public void addStudentService(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.addStudentMapper(student);
    }

    //根据ID查询学员
    @Override
    public Student selectstudentByIdService(Integer id) {
        return studentMapper.selectStudentByIdMapper(id);
    }

    //修改学员信息
    @Override
    public void modifyStudentService(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.modifyStudentMapper(student);
    }

    //学员违纪处理
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void violationStudentService(Integer id, Integer score) {
        Student student = studentMapper.selectStudentByIdMapper(id);
        Integer violationScore = student.getViolationScore();
        Integer violationCount = student.getViolationCount();
        student.setViolationCount(++violationCount);
        student.setViolationScore(violationScore+score);
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.modifyStudentMapper(student);
    }
}
