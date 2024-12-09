package top.lilong.mall.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lilong.mall.VO.RedisCommodityVO;
import top.lilong.mall.util.RedisUtil;

/**
 * @author Lilong
 * * @date 2024/12/9
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisUtil redisUtil;

    @PostMapping("/setAndTime")
    public void setAndTime(@Valid @RequestBody RedisCommodityVO commodityVO) {
        redisUtil.set(commodityVO.getCommodityKey());
    }
}
