package com.gmall.demo.controller;

import com.gmall.demo.service.DemoService;
import com.gmall.base.result.BaseProvider;
import com.gmall.module.demo.entity.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/admin/demo")
@Slf4j
public class DemoController  extends BaseProvider {
    @Autowired
    private DemoService demoService;



    @RequestMapping("/getById/{id}")
    public Object domeById(@PathVariable("id") Long id){
        Demo demo = demoService.findById(id);
        System.out.println("11111111111111");
        return handleSuccess(demo);
    }

}
