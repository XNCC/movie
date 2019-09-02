package ncc.movie.movie.controller;

import ncc.movie.movie.pojo.emailBean;
import ncc.movie.movie.utils.reciveEmails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.AccountException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmailController {
    @Autowired
    ncc.movie.movie.utils.reciveEmails reciveEmails;

    @RequestMapping("/email")
    public String inEmail( Model model) throws Exception {
        List<emailBean> xlsuosnanxkibafj = reciveEmails.receiveQQEmail("1114217951@qq.com", "xlsuosnanxkibafj");
            model.addAttribute("total", xlsuosnanxkibafj.get(0).getTotal());
            model.addAttribute("list", xlsuosnanxkibafj);
            return "email";
    }

    @RequestMapping("/email/{id}")
    public String inEmail(@PathVariable("id")int id, Model model) throws Exception {
        List<emailBean> xlsuosnanxkibafj = reciveEmails.receiveQQEmail("1114217951@qq.com", "xlsuosnanxkibafj");
              List<emailBean> list=new ArrayList<>();
            emailBean emailBean = xlsuosnanxkibafj.get(id);
       // System.out.println(xlsuosnanxkibafj);
        list.add(emailBean);
            model.addAttribute("bean",list);
             System.out.println(list);
            return "email";

    }

    Map<String, Object> map = new HashMap<String, Object>();
    @RequestMapping("/emailList")
    @ResponseBody
    private Map selectsome(String current, String pageSize) throws Exception {
        List<emailBean> list=new ArrayList<>();
        int i1 = Integer.parseInt(current);
        int i2 = Integer.parseInt(pageSize);
        System.out.println(">?>>>"+i1);
        List<emailBean> xlsuosnanxkibafj = reciveEmails.receiveQQEmail("1114217951@qq.com", "xlsuosnanxkibafj");
        if(xlsuosnanxkibafj!=null) {
            int start=(i1-1)*10;
            int end=start+10;
            int flag=0;

            map.put("rows", xlsuosnanxkibafj);

        }
        return map;
    }

}
