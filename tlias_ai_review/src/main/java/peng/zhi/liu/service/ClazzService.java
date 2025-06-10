package peng.zhi.liu.service;

import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    //分页查询
    public PageResult<Clazz> selectClazzPageService(ClazzQueryParam clazzQueryParam);
    //删除班级
    public void deleteClazzService(Integer id);
    //添加班级
    public void addClazzService(Clazz clazz);
    //根据ID查询班级
    public Clazz selectClazzByIdService(Integer id);
    //修改班级信息
    public void modifyClazzService(Clazz clazz);
    //查询所有班级
    public List<Clazz> selectAllClazzService();
}
