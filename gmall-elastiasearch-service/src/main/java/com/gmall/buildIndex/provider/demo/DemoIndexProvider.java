package com.gmall.buildIndex.provider.demo;

import com.gmall.buildIndex.entity.DemoEntity;
import com.gmall.base.result.BaseResponse;
import com.gmall.base.result.BusinessException;
import com.gmall.base.search.IIndexProvider;
import com.gmall.module.demo.entity.Demo;
import com.gmall.module.demo.feign.DemoFeignService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author syr
 * @Description
 * @create 2020-03-11 17:26
 **/
@Component
public class DemoIndexProvider implements IIndexProvider<DemoEntity> {

    @Resource
    private DemoFeignService demoFeignService;

    @Override
    public DemoEntity getEntity(Long id) throws BusinessException {
        BaseResponse baseResponse = demoFeignService.domeById(id);
        if(baseResponse.getData()==null&&(Demo) baseResponse.getData()!=null){
            return null;
        }
        Demo demo = (Demo) baseResponse.getData();
        DemoEntity demoEntity = new DemoEntity();
        BeanUtils.copyProperties(demo,demoEntity);
        int[] bounds=new int[]{45,78,62,89,36,78,25,1,35,78};
        demoEntity.setBounds(bounds);
        return demoEntity;
    }
}
