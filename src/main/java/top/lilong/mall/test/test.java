package top.lilong.mall.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@SpringBootTest
public class test {


    public   static void main(String[] args) {
        String password = "123456";
        String salt = UUID.randomUUID().toString();
        System.out.println(salt);
        String md5 = DigestUtils.md5DigestAsHex((password+salt).getBytes());
        System.out.println(md5);
    }
}
