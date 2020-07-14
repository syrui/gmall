package com.gmall.demo.service.impl;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gmall.demo.mapper.DemoMapper;
import com.gmall.demo.service.DemoService;
import com.gmall.module.BaseEntityManager;
import com.gmall.util.JsonBinder;
import com.gmall.module.demo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 库存单元表 服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

@Service
public class   DemoServiceImpl extends BaseEntityManager<Demo,Long> implements DemoService {

    @Autowired
    DemoMapper demoMapper;

    @Override
    public Demo findById(Long demoId) {
        Demo demo=null;
        String toJson=null;
        Object o = redisTemplate.opsForValue().get(Demo.class.getName()+":id-"+demoId);
        if(o==null){
            demo= demoMapper.selectById(demoId);
            toJson = JsonBinder.buildNonNullBinder().toJson(demo);
            redisTemplate.opsForValue().set(Demo.class.getName()+":id-"+demoId,toJson,60*3, TimeUnit.SECONDS);
        }else {
            demo = JsonBinder.buildNonNullBinder().toBean(String.valueOf(o), Demo.class);
        }


        return demo;
    }

    @Override
    protected BaseMapper<Demo> getEntityDao() {
        return demoMapper;
    }

    @Override
    protected String clearRedisCacheKeys() {
        return "demo:id-";
    }
}