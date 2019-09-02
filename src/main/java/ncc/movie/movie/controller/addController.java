package ncc.movie.movie.controller;

import ncc.movie.movie.pojo.VideoBean;
import ncc.movie.movie.service.Service;
import ncc.movie.movie.utils.BaseParamats;
import ncc.movie.movie.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
public class addController {
    @Autowired
    Service service;
    //跳转页面
    @RequestMapping("/add")
    public String addd(){
        return "add";
    }

    //录入音乐url
    @PostMapping("/uploadVideos")
    public Callable<String>  insert_music(String video_name, String video_score, String video_count,String actor_name,String director,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date video_time,String type_type,String area_name,
                               String details,String vipcansee,
                               @RequestParam("vidoe_url") MultipartFile vidoe_url,
                               @RequestParam("img_url") MultipartFile img_url)
            throws IOException, SQLException {
        System.out.println("主线程启动");
        //放在多线程里面处理
        Callable<String> result=new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println("副线程启动");
                String vidoe_urls=vidoe_url.getOriginalFilename();
                String img_urls=img_url.getOriginalFilename();
                String suffix1 = vidoe_urls.split("\\.")[1];
                String suffix2 = img_urls.split("\\.")[1];
                String name_suffix1=UUID.randomUUID().toString()+"."+suffix1;
                String name_suffix2=UUID.randomUUID().toString()+"."+suffix2;
                //上传mv     路径保存在数据库
                String pathvideo="D:/videos/"+  name_suffix1;
                BufferedOutputStream videoout=new BufferedOutputStream(new FileOutputStream(pathvideo));
                videoout.write(vidoe_url.getBytes());
                videoout.flush();
                videoout.close();
                //上传img    路径保存在数据库
                String imgpath="D:/imgs/"+name_suffix2;
                BufferedOutputStream imgout=new BufferedOutputStream(new FileOutputStream(imgpath));
                imgout.write(img_url.getBytes());
                imgout.flush();
                imgout.close();
                System.out.println(type_type);
                VideoBean videoBean=new VideoBean();
                videoBean.setVideo_url("/video/"+name_suffix1);
                videoBean.setImg_url("/imgs/"+name_suffix2);
                videoBean.setVideo_name(video_name);
                videoBean.setVideo_score(video_score);
                videoBean.setVideo_time(video_time);
                videoBean.setVideo_count(video_count);
                videoBean.setActor_name(actor_name);
                videoBean.setDirectors(director);
                videoBean.setArea_name(area_name);
                videoBean.setType_type(type_type);
                videoBean.setVideo_details(details);
                videoBean.setVipcansee(vipcansee);
                service.addVideo(videoBean);
                System.out.println("副线程结束");
                System.out.println(videoBean);

                return "redirect:add";
            }
        };
        System.out.println("主线程结束");
        return result;
    }
}
