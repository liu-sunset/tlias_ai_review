package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peng.zhi.liu.pojo.Emp;
import peng.zhi.liu.pojo.LoginInfo;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.service.LoginService;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    //用户登录请求
    @PostMapping
    public Result loginController(@RequestBody Emp emp){
        log.info("用户登录:{}",emp);
        LoginInfo login = loginService.loginService(emp);
        if(login==null){
            return Result.error("用户名或密码错误");
        }else {
            return Result.success(login);
        }
    }
}
