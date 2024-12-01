package top.lilong.mall.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.lilong.mall.util.ResultData;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/test")
public class TestController {

    @GetMapping(value = "/test")
    public ResultData<String> Hello(){
        return ResultData.success("Hello");
    }
}
