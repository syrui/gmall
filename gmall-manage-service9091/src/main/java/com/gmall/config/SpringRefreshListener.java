package com.gmall.config;


import com.gmall.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
public class SpringRefreshListener implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger logger = LoggerFactory.getLogger(SpringRefreshListener.class);

    /**
     * springMVC启动加载权限
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        if (!(context instanceof WebApplicationContext)) return;
        //配置SpringContextUtil的参数
        logger.info("---------------- 启动完成,执行启动完成方法 --------------------");
        SpringContextUtil.applicationContext = context;
    }

}
