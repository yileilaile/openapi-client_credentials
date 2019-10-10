package com.instai.open.baseinfo.com.instai.open.baseinfo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping("getName")
    public Map<String, String> getName(){
        Map<String,String> map = new HashMap<>();
        map.put("test","test");
        return map;
    }

}
