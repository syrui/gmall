package com.gmall.module.demo.feign;

import com.gmall.base.result.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是一个声明式的远程调用
 */

@Component
@FeignClient(value = "gmall-manage-service",fallback = DemoFallbackService.class)
public interface DemoFeignService {

    @RequestMapping("/admin/demo/getById/{id}")
    BaseResponse domeById(@PathVariable("id") Long id);

}
