package peng.zhi.liu.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.Student;
import peng.zhi.liu.pojo.StudentQueryParam;

import java.util.List;

@Mapper
public interface StudentMapper {
    //分页查询
    public Page<Student> selectStudentPageMapper(StudentQueryParam studentQueryParam);
    //批量删除学员
    public void deleteStudentMapper(List<Integer> ids);
    //添加学员
    public void addStudentMapper(Student student);
    //根据ID查询学员
    public Student selectStudentByIdMapper(Integer id);
    //修改学员信息
    public void modifyStudentMapper(Student student);
}
