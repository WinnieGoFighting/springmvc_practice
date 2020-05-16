package com.ni.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PUT;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {

    //演示传统方式的文件上传
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file= new File(path);
        if (!file.exists())
            file.mkdirs();

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item:items){
            if (item.isFormField()) {
                //说明是普通表单项
            } else {
                //说明时文件上传项
                //获取到上传文件的名称
                String filename = item.getName();
                String[] info=filename.split("\\\\");
                filename=info[info.length-1];
                System.out.println(filename);

                //把文件的名称设置成唯一值
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename=uuid+"_"+filename;
               item.write(new File(path,filename));
               //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    //springMVC文件上传
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file= new File(path);
        if (!file.exists())
            file.mkdirs();
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;
        upload.transferTo(new File(path,filename));
        return "success";
    }

    //跨服务器文件上传
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws IOException {
        //定义上传文件服务器路径
        String path = "http://localhost:9090/uploads";

        String filename = upload.getOriginalFilename();
//        String uuid = UUID.randomUUID().toString().replace("-","");
//        filename=uuid+"_"+filename;

        //创建客户端对象
        Client client = Client.create();
        WebResource webResource = client.resource(path+"/"+filename);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
