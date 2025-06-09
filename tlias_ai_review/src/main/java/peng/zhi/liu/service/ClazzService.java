package peng.zhi.liu.service;

import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    //分页查询
    public PageResult<Clazz> selectClazzPageService(ClazzQueryParam clazzQueryParam);
}
