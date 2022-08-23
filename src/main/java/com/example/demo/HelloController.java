package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zero
 */
@RestController
public class HelloController {
    @Value("${jks.path}")
    private String path;

    @RequestMapping("/hello")
    public Map<String, String> hello(@RequestParam("data") String data){
        Map<String, String> map = new HashMap<>();

        try {
            map.put("code", "200");
            map.put("data", data);
            map.put("msg", "成功");
            map.put("path", path);
            map.put("pwd", Constants.JKS_PWD);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("data", data);
            map.put("msg", "失败");
            return map;
        }


    }
}
