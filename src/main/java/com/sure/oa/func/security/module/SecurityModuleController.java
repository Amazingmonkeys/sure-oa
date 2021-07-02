package com.sure.oa.func.security.module;

import com.sure.oa.base.Result;
import com.sure.oa.dto.MenuDto;
import com.sure.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/security/module")
public class SecurityModuleController {

    @Autowired
    private SecurityModuleService securityModuleService;

    @GetMapping("")
    public List<MenuDto> menuList() {
        return securityModuleService.getMenuList();
    }

    @GetMapping("/{u_id}")
    public List<Integer> userMenuIdList(@PathVariable String u_id) {
        return securityModuleService.getUserMenuList(u_id);
    }

    @GetMapping("/user")
    public List<User> userList() {
        return securityModuleService.getUserList();
    }

    @PutMapping("/unuse/{u_id}")
    //@PathVariable表示参数是路径变量，与路径中{}相同
    public Result unuseUser(@PathVariable String u_id) {
        securityModuleService.unuseUser(u_id);
        return Result.success("用户已被成功禁用！");
    }

    @PutMapping("/use/{u_id}")
    //@PathVariable表示参数是路径变量，与路径中{}相同
    public Result useUser(@PathVariable String u_id) {
        securityModuleService.useUser(u_id);
        return Result.success("用户已被成功启用！");
    }

    @PutMapping("/setModule/{u_id}")
    //@RequestBody说明的参数用于接受payload方式提交的JSON数据
    public Result setModule(@PathVariable String u_id, @RequestBody Integer[] moduleIds) {
        securityModuleService.setModule(u_id, moduleIds);
        return Result.success("用户" + u_id + "的权限已被更新成功！");
    }
}
