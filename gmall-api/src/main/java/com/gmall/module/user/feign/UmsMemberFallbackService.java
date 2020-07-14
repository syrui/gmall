package com.gmall.module.user.feign;

import com.gmall.base.result.BaseProvider;
import org.springframework.stereotype.Component;

@Component
public class UmsMemberFallbackService extends BaseProvider implements UmsMemberFeignService {

}