package top.lilong.mall.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lilong.mall.common.MD5config;
import top.lilong.mall.dao.PasswordAndSaltDao;
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
    @Autowired
    private PasswordAndSaltDao passwordAndSaltDao;
    @Override
    public User selectUserByUsernameAndPassword(String username,String password) {
        //查找盐值
        String salt = passwordAndSaltDao.selectSaltByUsername(username);
        //md5加密
        String newPassword = MD5config.md5(salt,password);
        return userDao.selectUserByUsernameAndPassword(username,newPassword);
    }
}
