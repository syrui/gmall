package com.gmall.module.file;

import com.gmall.fastdfs.util.FileDfsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author by imall core generator
 * @version 1.0.0
 */

@Controller
@RequestMapping("/file")
public class FileController {
    @Value("${com.gmall.web.fileWebUrl}")
  private String url;

    @Resource
    private FileDfsUtil fileDfsUtil ;
    /**
     * 文件上传
     */

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile (@RequestParam("file") MultipartFile file){
        String result ;
        try{

            String path;
            String originalFilename = file.getOriginalFilename();

            String substring = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            if(originalFilename.endsWith(".jpg")||originalFilename.endsWith(".png")
                    ||originalFilename.endsWith(".jpeg")){
                path= fileDfsUtil.uploadImage(file.getInputStream(),file.getSize(),substring,null) ;
            }else{
                path= fileDfsUtil.uploadFile(file.getInputStream(),file.getSize(),substring,null) ;
            }

            System.out.println(path);
            if (!StringUtils.isEmpty(path)){
                result = url+path+"@@"+path ;
            } else {
                result = "上传失败" ;
            }
        } catch (Exception e){
            e.printStackTrace() ;
            result = "服务异常" ;
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFiles(HttpServletRequest request){
        String result ;
        List<String> fileProtocolList = new ArrayList<>();
        try{
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        commonsMultipartResolver.setDefaultEncoding("utf-8");

        if(commonsMultipartResolver.isMultipart(request) && request instanceof MultipartHttpServletRequest){


            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = multipartRequest.getFileNames();
            while(iterator.hasNext()){
                MultipartFile file = multipartRequest.getFile(iterator.next());
                String originalFilename = file.getOriginalFilename();
                String path ="";
                if(originalFilename.endsWith(".jpg")||originalFilename.endsWith(".png")
                        ||originalFilename.endsWith(".jpeg")){
                    path= fileDfsUtil.uploadImage(file.getInputStream(),file.getSize(),file.getOriginalFilename(),null) ;
                }else{
                    path= fileDfsUtil.uploadFile(file.getInputStream(),file.getSize(),file.getOriginalFilename(),null) ;
                }


                if (!StringUtils.isEmpty(path)){
                    result = path ;
                } else {
                    result = "上传失败" ;
                }
                fileProtocolList.add(originalFilename+"="+result+"");

            }
        }


        } catch (Exception e){
            e.printStackTrace() ;
            result = "服务异常" ;
        }
        return ResponseEntity.ok(fileProtocolList.toString());
    }




}