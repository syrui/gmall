package com.gmall.demo.controller;

import com.gmall.demo.service.DemoService;
import com.gmall.base.result.BaseProvider;
import com.gmall.base.result.BaseResponse;
import com.gmall.module.demo.entity.Demo;
import com.gmall.module.demo.feign.DemoFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController()
@RequestMapping("/admin/demo")
@Slf4j
public class DemoController  extends BaseProvider {
    @Autowired
    private DemoService demoService;

    @Resource
    private DemoFeignService demoFeignService;


    @RequestMapping("/getById/{id}")
    public Object domeById(@PathVariable("id") Long id){
        Demo demo = demoService.findById(id);
        System.out.println("00000000000");
        return handleSuccess(demo);
    }
    @RequestMapping("/test/{id}")
    public Object test(@PathVariable("id") Long id){
        BaseResponse response = demoFeignService.domeById(id);
        return response; }
}
