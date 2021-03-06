package com.gmall.module.demo.feign;

import com.gmall.base.eum.ErrorCode;
import com.gmall.base.result.BaseProvider;
import com.gmall.base.result.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoFallbackService extends BaseProvider implements DemoFeignService {
    @Value("${server.port}")
    private String serverPort;

    @Override
    public BaseResponse domeById(Long id) {
        return handleError(ErrorCode.SYS_NOT_FOUND.getErrorMSg()+"   "+serverPort);
    }
}
