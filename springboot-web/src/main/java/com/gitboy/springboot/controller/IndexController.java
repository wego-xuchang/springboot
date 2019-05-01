package com.gitboy.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration
@Controller
public class IndexController {

    @RequestMapping("/index'")
    public String index(Map<String, Object> map) {
        map.put("name","hello...");
        map.put("sex", "1");

        List<String> userlist = new ArrayList<String>();
        userlist.add("zhangsan");
        userlist.add("lisi");
        userlist.add("itmayiedu");

        map.put("userlist", userlist);
        return "index";
    }
    public static void main(String[] args) {
		SpringApplication.run(IndexController.class, args);
	}

}
