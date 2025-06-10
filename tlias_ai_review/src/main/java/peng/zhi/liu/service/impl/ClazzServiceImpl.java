package peng.zhi.liu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import peng.zhi.liu.mapper.ClazzMapper;
import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.service.ClazzService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired

    private ClazzMapper clazzMapper;
    //分页查询
    @Override
    public PageResult<Clazz> selectClazzPageService(ClazzQueryParam clazzQueryParam) {
        //开启分页查询
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        Page<Clazz> page = clazzMapper.selectClazzPageMapper(clazzQueryParam);
        return new PageResult<Clazz>(page.getTotal(),page.getResult());

    }

    //删除班级
    @Override
    public void deleteClazzService(Integer id) {
        clazzMapper.deleteClazzMapper(id);
    }

    //添加班级
    @Override
    public void addClazzService(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazzMapper(clazz);
    }

    //根据ID查询班级
    @Override
    public Clazz selectClazzByIdService(Integer id) {
        return clazzMapper.selectClazzByIdMapper(id);
    }

    //修改班级信息
    @Override
    public void modifyClazzService(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.modifyClazzMapper(clazz);
    }

    //查询所有班级
    @Override
    public List<Clazz> selectAllClazzService() {
       return clazzMapper.selectAllClazzMapper();
    }
}
