package com.gmall.buildIndex.processor.module.demo;

import com.gmall.buildIndex.mapper.DemoMapper;
import com.gmall.buildIndex.processor.BaseIndexProcesser;
import com.gmall.buildIndex.provider.demo.DemoIndexProvider;
import com.gmall.base.search.IIndexProvider;
import com.gmall.base.search.ISearchEntity;
import com.gmall.base.search.SysIndexObjectTypeCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author syr
 * @Description
 * @create 2020-03-11 19:23
 **/
@Component
public class DemoIndexProcesser extends BaseIndexProcesser {


    @Autowired
    DemoIndexProvider demoIndexProvider;

    @Resource
    DemoMapper demoMapper;


    @Override
    public ElasticsearchRepository getElasticsearchRepository() {
        return demoMapper;
    }



    @Override
    public IIndexProvider<? extends ISearchEntity> getProvider() {
        return demoIndexProvider;
    }

    @Override
    public SysIndexObjectTypeCodeEnum getObjectTypeCode() {
        return SysIndexObjectTypeCodeEnum.DEMO;
    }
}
