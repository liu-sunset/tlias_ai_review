package peng.zhi.liu.mapper;

import org.apache.ibatis.annotations.Mapper;
import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.LoginInfo;

@Mapper
public interface LoginMapper {
    //用户登录请求
    public LoginInfo loginMapper(Emp emp);
}
