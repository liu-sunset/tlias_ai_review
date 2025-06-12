package peng.zhi.liu.service;

import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.LoginInfo;

public interface LoginService {
    //用户登录请求
    public LoginInfo loginService(Emp emp);
}
