package peng.zhi.liu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peng.zhi.liu.mapper.LoginMapper;
import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.LoginInfo;
import peng.zhi.liu.service.LoginService;
import peng.zhi.liu.utils.JWT;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    //用户登录请求
    @Override
    public LoginInfo loginService(Emp emp) {
        LoginInfo login = loginMapper.loginMapper(emp);
        if(login==null){
            return null;
        }else{
            //生成jwt令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",login.getId());
            claims.put("username",login.getUsername());
            String token = JWT.generateJWT(claims);
            return new LoginInfo(login.getId(),login.getUsername(),login.getUsername(),token);
        }
    }
}
