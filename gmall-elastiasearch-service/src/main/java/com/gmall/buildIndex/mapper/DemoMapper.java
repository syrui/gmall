package com.gmall.buildIndex.mapper;


import com.gmall.buildIndex.entity.DemoEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoMapper extends ElasticsearchRepository<DemoEntity, Long> {

}
