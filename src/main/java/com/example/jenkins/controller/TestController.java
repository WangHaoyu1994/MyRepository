package com.example.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Description   :
 * @ Author        :  why
 * @ CreateDate    :  2020/12/20$ 14:10$
 * @ UpdateDate    :  2020/12/20$ 14:10$
 * @ UpdateRemark  :  修改内容
 * @ Version       :  1.0
 * @ Since         :  JDK 1.8
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String testController(){
        return "hello";
    }

}
