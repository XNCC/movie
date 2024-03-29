package ncc.movie.movie.Config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    //    在请求处理之前调用,只有返回true才会执行请求
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        得到session
        HttpSession session = httpServletRequest.getSession(true);
        Object admin = session.getAttribute("admin");
//        判断对象是否存在
        if(admin!=null){
            return true;
        }else{
            httpServletResponse.sendRedirect("/tologin");
            return false;
        }
    }


}
