package org.gongxuanzhang.tocbx.springbootstarter.controller;



import com.aaa.demospringboot.start.Time;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@RestController
public class TestController {


    @PostMapping("/test")
    public String test(@RequestBody Map<String, Object> map, @Time Long time) {
        return "ok";
    }
}
