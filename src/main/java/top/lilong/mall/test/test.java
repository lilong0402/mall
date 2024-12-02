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
//        String password = "123456";
//        String salt = "e885686e-98ef-44a9-8f29-5478dc977d27";
//        System.out.println(salt);
//        String md5 = DigestUtils.md5DigestAsHex((password+salt).getBytes());
//        System.out.println(md5);
        for (int i = 0; i < 9; i++) {
            System.out.println((int)(Math.random()*10)+1);
        }
    }
}
