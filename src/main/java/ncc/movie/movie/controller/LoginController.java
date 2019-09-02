package ncc.movie.movie.controller;

import ncc.movie.movie.pojo.User;
import ncc.movie.movie.pojo.userBean;
import ncc.movie.movie.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
public class LoginController {

        @Autowired
        ncc.movie.movie.service.adminService adminService;
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @GetMapping("/signIn")
    public String login(String username, String password, HttpServletRequest request, Model model) throws SQLException {
        User admin = adminService.getAdmin(username);
        if(admin!=null){
            System.out.println(admin);
            String img_url=admin.getUserimg_url();
            if(username.equals(admin.getUsername())&&password.equals(admin.getPassword())){
                request.getSession().setAttribute("admin","管理员："+username);
                request.getSession().setAttribute("img_url",img_url);
                request.getSession().setAttribute("userid",admin.getUserid());
                request.getSession().setAttribute("vip",admin.getVip());
                request.getSession().setAttribute("starttime",admin.getStarttime());
                request.getSession().setAttribute("endtime",admin.getEndtime());
                request.getSession().setAttribute("phone",admin.getPhone());
                System.out.println(username);
                System.out.println(password);
                return "redirect:earning";
            }else{
                model.addAttribute("error","密码错误");
                return "login";
            }
        }else{
            model.addAttribute("error","账户不存在");
            return "login";
        }

    }


    @RequestMapping("/persionPage")
    public String persion(){
        return "persionPage";
    }
}
