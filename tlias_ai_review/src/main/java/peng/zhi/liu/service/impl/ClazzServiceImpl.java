package peng.zhi.liu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.mapper.ClazzMapper;
import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.service.ClazzService;

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
}
