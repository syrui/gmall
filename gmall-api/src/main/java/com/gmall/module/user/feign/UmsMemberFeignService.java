package com.gmall.module.user.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * 这是一个声明式的远程调用
 */

@Component
@FeignClient(value = "XXXX",fallback = UmsMemberFallbackService.class)
public interface UmsMemberFeignService {

}