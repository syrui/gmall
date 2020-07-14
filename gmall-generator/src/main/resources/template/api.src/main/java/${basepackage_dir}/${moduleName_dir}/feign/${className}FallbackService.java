<#assign className=table.className>
package ${basepackage}.${moduleName}.feign;

import com.gmall.base.eum.ErrorCode;
import com.gmall.base.result.BaseProvider;
import com.gmall.base.result.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ${className}FallbackService extends BaseProvider implements ${className}FeignService {

}