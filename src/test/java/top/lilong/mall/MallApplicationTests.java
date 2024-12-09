package top.lilong.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.lilong.mall.util.RedisUtil;

@SpringBootTest
class MallApplicationTests {
    @Autowired
    RedisUtil redisUtil;
//    @Test
//    public void contextLoads() {
//        redisUtil.set("test:key:name", "xxxxxx");
//        redisUtil.set("test:key:name2", "yyyyy");
//
//        redisUtil.delete("test:key:name2");
//        System.out.println(redisUtil.getString("test:key:name2"));
//    }

}
