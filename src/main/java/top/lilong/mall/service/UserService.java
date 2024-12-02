package top.lilong.mall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import top.lilong.mall.domain.User;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */

public interface UserService extends IService<User> {
    User selectUserByUsernameAndPassword(String username,String password);
}
