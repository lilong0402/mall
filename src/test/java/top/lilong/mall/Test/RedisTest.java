package top.lilong.mall.Test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.lilong.mall.util.RedisUtil;

/**
 * @author Lilong
 * * @date 2024/12/9
 * @version 1.0
 */
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        redisUtil.set("test:key:name", "xxxxxx");
        redisUtil.set("test:key:name2", "yyyyy");
        System.out.println(redisUtil.getString("test:key:name2"));
    }
}
