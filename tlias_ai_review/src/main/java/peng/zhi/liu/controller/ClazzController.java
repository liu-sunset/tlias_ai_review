package peng.zhi.liu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import peng.zhi.liu.pojo.Clazz;
import peng.zhi.liu.pojo.ClazzQueryParam;
import peng.zhi.liu.pojo.PageResult;
import peng.zhi.liu.pojo.Result;
import peng.zhi.liu.service.ClazzService;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    //分页查询
    @GetMapping
    public Result selectClazzPageController(ClazzQueryParam clazzQueryParam){
        log.info("分页查询：{}",clazzQueryParam);
        PageResult<Clazz> pageResult =  clazzService.selectClazzPageService(clazzQueryParam);
        return Result.success(pageResult);
    }
}
