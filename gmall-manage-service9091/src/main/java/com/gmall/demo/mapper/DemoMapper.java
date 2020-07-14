package com.gmall.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gmall.module.demo.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存单元表 JPA 持久化层
 * @author by imall core generator
 * @version 1.0.0
 */
@Mapper
public interface DemoMapper extends BaseMapper<Demo> {

    Demo byId(Long id);
}