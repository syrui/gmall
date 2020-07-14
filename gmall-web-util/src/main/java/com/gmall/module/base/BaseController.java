package com.gmall.module.base;

import org.springframework.beans.factory.annotation.Value;


public class BaseController {
    @Value("${com.gmall.web.fileWebUrl}")
    private String fileWebUrl;

    protected String getServicePath(){
        return fileWebUrl;
    }

    protected String handleImgPath(String fileId){
       return fileWebUrl+fileId;
    }


}
