package top.lilong.mall.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    @Tag(name="测试模块",description = "初始测试")
    public String Hello(){
        return "Hello World";
    }
}
