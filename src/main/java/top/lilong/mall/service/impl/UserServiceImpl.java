package top.lilong.mall.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lilong.mall.common.MD5config;
import top.lilong.mall.dao.PasswordAndSaltDao;
import top.lilong.mall.dao.SysLogDao;
import top.lilong.mall.dao.UserDao;
import top.lilong.mall.domain.User;
import top.lilong.mall.service.UserService;

import java.util.UUID;

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
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public User selectUserByUsernameAndPassword(String username,String password) {
        //查找盐值
        String salt = passwordAndSaltDao.selectSaltByUsername(username);
        //md5加密
        String newPassword = MD5config.md5(salt,password);

        User user = userDao.selectUserByUsernameAndPassword(username, newPassword);
        if (user==null) {
            sysLogDao.insert("用户"+username + "进行登陆操作，但可能用户名或者密码输入错误");
            return null;
        }
        sysLogDao.insert("用户"+username+"登陆成功");
        //我们设置以1/10的几率来修改盐值
        int number = (int)(Math.random()*10)+1;
        if (number == 5){
            //设置新的盐值
            String newsalt = UUID.randomUUID().toString();
            System.out.println(newsalt);
            passwordAndSaltDao.updateSalt(newsalt, username);
            sysLogDao.insert("用户"+username+"的盐值由"+salt +"改为" + newsalt);
            String userPassword = MD5config.md5(newsalt,password);
            userDao.updatePassword(username, userPassword);
            sysLogDao.insert("用户"+username+"由于修改了盐值密码由"+newPassword +"改为" + userPassword);
        }
        return user;
    }

}
