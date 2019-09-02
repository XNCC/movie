package ncc.movie.movie.controller;

import ncc.movie.movie.pojo.User;
import ncc.movie.movie.pojo.UserBeans;
import ncc.movie.movie.pojo.VideoBean;
import ncc.movie.movie.pojo.userBean;
import ncc.movie.movie.service.UserService;
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
public class userController {
    @Autowired
    UserService userService;
    Map<String, Object> map = new HashMap<String, Object>();

    @RequestMapping("/usermanage")
    public String usermanager(Model model) throws SQLException {
        int i = userService.selCount();
        model.addAttribute("pageNum",(i%10)>0?(i/10)+1:(i/10) );
        return "usermanage";
    }
    //模糊查询查询user,,,同名用户可能很很多分也是用
    @RequestMapping("/Oneuser")
    @ResponseBody
    public Map selectont(String name,int current,int pageSize,Model model) throws SQLException {
        System.out.println(name);
        if(name!=null){
        List<User> list= userService.selUserlike(name,current,pageSize);
        map.put("rows",list);
        int i = userService.selCount();
        model.addAttribute("pageNum",(i%10)>0?(i/10)+1:(i/10) );
        return map;
        }
        else{
            return null;
        }
    }

//查询多个user   分页使用占时没用到
    @RequestMapping("/userlist")
    @ResponseBody
    public Map userlist(String current, String pageSize) throws SQLException {
        System.out.println(current+" "+pageSize);
        int i = Integer.parseInt(current);
        int i1 = Integer.parseInt(pageSize);
        List<User> allUser = userService.findAllUser((i-1)*10,10);
        map.put("rows",allUser);
        return map;
    }

    //删除用户
    @RequestMapping("/userdel")
    @ResponseBody
    public int delUser( int userid) throws SQLException {
        int i = userService.delUser(userid);
        System.out.println(i);
        return i;
    }

    //查询单个用户
    @RequestMapping("/getOneUser")
    @ResponseBody
    public UserBeans selUserone(int userid) throws SQLException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        UserBeans userBeans = userService.selUserone(userid);
        String start = sdf.format(userBeans.getStarttime());
        String end = sdf.format(userBeans.getEndtime());
        userBeans.setEnd(end);
        userBeans.setStart(start);

        return userBeans;
    }

//    更新用户
    @PostMapping("/updUser")
    public String up(int userid, UserBeans userBeans) throws SQLException, ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String start = userBeans.getStart();
        String end = userBeans.getEnd();
        userBeans.setStarttime(sdf.parse(start));
        userBeans.setEndtime( sdf.parse(end));
        userService.updUser(userid,userBeans);

        return "redirect:usermanage";
    }

}
