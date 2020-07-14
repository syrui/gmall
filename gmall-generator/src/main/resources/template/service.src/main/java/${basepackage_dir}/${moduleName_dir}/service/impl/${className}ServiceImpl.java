
<#assign className=table.className>
 <#assign classNameLower=className?uncap_first>
package ${basepackage}.${moduleName}.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gmall.module.BaseEntityManager;
import com.gmall.base.eum.ErrorCode;
import com.gmall.base.result.BusinessException;
import ${basepackage}.${moduleName}.mapper.${className}Mapper;
{basepackage}.${moduleName}.entity.${className};
{basepackage}.${moduleName}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ${table.remarks} 服务层实现
 * @author by imall core generator
 * @version 1.0.0
 */

@Service
public class   ${className}ServiceImpl  extends BaseEntityManager<${className},Long>  implements  ${className}Service{

    @Autowired
     ${className}Mapper  ${classNameLower}Mapper;

    @Override
    protected BaseMapper<${className}> getEntityDao() {
        return ${classNameLower}Mapper;
        }

    @Override
    protected String clearRedisCacheKeys() {
        return null;
      }

        }