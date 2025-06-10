package peng.zhi.liu.service;

import peng.zhi.liu.mapper.StudentMapper;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.Student;
import peng.zhi.liu.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    //分页查询
    public PageResult<Student> selectStudentPageService(StudentQueryParam studentQueryParam);
    //批量删除学员
    public void deleteStudentService(List<Integer> ids);
    //添加学员
    public void addStudentService(Student student);
    //根据ID查询学员
    public Student selectstudentByIdService(Integer id);
    //修改学员信息
    public void modifyStudentService(Student student);
    //学员违纪处理
    public void violationStudentService(Integer id,Integer score);
}
