package top.lilong.mall.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lilong.mall.domain.User;
import top.lilong.mall.service.UserService;
import top.lilong.mall.util.ResultData;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
@Tag(name="用户模块",description = "用户操作")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultData<User> login(String username, String password) {
        return ResultData.success(userService.selectUserByUsername(username,password));
    }
}
