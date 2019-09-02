package ncc.movie.movie.controller;

import com.github.pagehelper.PageInfo;
import ncc.movie.movie.pojo.CommentBean;
import ncc.movie.movie.pojo.MessageBean;
import ncc.movie.movie.pojo.VideoBean;
import ncc.movie.movie.pojo.comments;
import ncc.movie.movie.service.ManageService;
import ncc.movie.movie.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class manageController {
@Autowired
ncc.movie.movie.service.Service Service;
@Autowired
    ManageService manageService;

    @RequestMapping("/manage")
    public String manager(Model model) throws SQLException {
        int videoCount = Service.getVideoCount();
        model.addAttribute("total",videoCount);
        model.addAttribute("pageSize",(videoCount%10)>0?videoCount/10+1:videoCount/10);
        return "manage";
    }

    /*
    数据封装到list即可
    分页
     */
    Map<String, Object> map = new HashMap<String, Object>();
    @RequestMapping("/pagelist")
    @ResponseBody
    private Map selectsome(String current, String pageSize) throws SQLException {
        System.out.println(current+" "+pageSize);
        int i = Integer.parseInt(current);

        int i2 = Integer.parseInt(pageSize);
        List<VideoBean> list= manageService.selList((i-1)*10,10);
        //将查询结果集封装到pageinfo对象中
        PageInfo<VideoBean> pageInfo = new PageInfo<VideoBean>(list);
        long total = pageInfo.getTotal();
        List<VideoBean> lists = pageInfo.getList();
        map.put("rows",lists);
        return map;
    }


    @RequestMapping("/select")
    @ResponseBody
    public Map selectont(String video_name) throws SQLException {
        System.out.println(video_name);
        List<VideoBean> list= manageService.findVideoList(video_name);
        map.put("rows",list);
        return map;
    }




    //删除电影信息
    @RequestMapping("/del")
    @ResponseBody
    public String  dele(int video_id) throws SQLException{
        System.out.println(">>>>>>>>>>>"+video_id);
        manageService.dele(video_id);
        return "success";
    }


    //    查询单个电影
    @RequestMapping("/getOneVideo")
    @ResponseBody
    public VideoBean getOneVideo(int video_id) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(video_id!=0){
            VideoBean oneVideo = manageService.getOneVideo(video_id);
            String format = sdf.format(oneVideo.getVideo_time());
            oneVideo.setTime(format);
            return oneVideo;
        }
        else{
            return null;
        }
    }

    @PostMapping("/updateVideo")
    public String  update(int video_id,String video_name,String video_score,String video_count
    ,String actor_name,String directors,String video_time,String type_type,String area_name
    ,String video_details) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        MessageBean MessageBean=new MessageBean();
        MessageBean.setVideo_name(video_name);
        MessageBean.setActor_name(actor_name);
        MessageBean.setArea_name(area_name);
        MessageBean.setDirectors(directors);
        MessageBean.setType_type(type_type);
        MessageBean.setVideo_details(video_details);
        MessageBean.setVideo_score(video_score);
        MessageBean.setVideo_count(video_count);
        MessageBean.setVideo_time(sdf.parse(video_time));

//        manageService.updateMessage(video_id,MessageBean);
        manageService.updateMessages(video_id,MessageBean);
        System.out.println(MessageBean);

        return "redirect:manage";
    }





    //根据电影id获取对应评论信息
    @RequestMapping("/User_comments/{video_id}")
    public String comments(@PathVariable("video_id") String video_id, Model model) throws SQLException {
        System.out.println("????"+video_id);
        int ii = Integer.parseInt(video_id);
        List<CommentBean> lists= manageService.selList(ii);
        System.out.println(lists);
        model.addAttribute("lists",lists);

        return "comments";
    }
    //根据电影id删除信息
    @RequestMapping("/delcomments")
    public String delcomments(int user_id) throws SQLException {
       int i= manageService.delcomment(user_id);
        System.out.println(i);
        return "comments";
    }
}
