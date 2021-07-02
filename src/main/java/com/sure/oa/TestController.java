package com.sure.oa;

import com.sure.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//说明这是一个控制器组件，并受Spring管理
public class TestController {

    //业务类（模型）封装行为
    @Autowired //表示由Spring自动按类型匹配的原则
    private TestService testService;

    @RequestMapping("/userList")
    public List<User> userList(){
        return testService.getUserList();
    }

    @RequestMapping("/test")
    public String helloWorld(){
        return "Hello World";
    }
}
