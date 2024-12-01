package top.lilong.mall.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lilong.mall.dao.UserDao;
import top.lilong.mall.domain.User;
import top.lilong.mall.service.UserService;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Integer selectUserByUsername(String username,String password) {
        return userDao.selectUserByUsername(username,password);
    }
}
