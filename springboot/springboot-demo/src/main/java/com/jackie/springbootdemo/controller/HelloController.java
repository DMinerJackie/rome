package com.jackie.springbootdemo.controller;

import com.jackie.springbootdemo.annotation.DemoAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request) {
        LOG.info("============打印日志开始============");
        LOG.info("URL: " + request.getRequestURL().toString());
        LOG.info("============打印日志结束============");
        return "hello jackie";
    }

    @GetMapping(value = "/test1")
    public String test1(HttpServletRequest request, String var1) {
//        LOG.info("============打印日志开始============");
//        LOG.info("URL: " + request.getRequestURL().toString());
//        LOG.info("============打印日志结束============");
        return "test1";
    }

    @DemoAnnotation
    @GetMapping(value = "/test2")
    public String test2(HttpServletRequest request, String var1, String var2) {
//        LOG.info("============打印日志开始============");
//        LOG.info("URL: " + request.getRequestURL().toString());
//        LOG.info("============打印日志结束============");
//        int i = 1/0;
        if (1<2)
            throw new IllegalArgumentException("exception");
        return "test2";
    }
}
