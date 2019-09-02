package ncc.movie.movie.controller;

import ncc.movie.movie.service.EarningService;
import ncc.movie.movie.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.krb5.internal.tools.Klist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class earningController {

        @Autowired
        ncc.movie.movie.service.EarningService EarningService;
        @Autowired
        ncc.movie.movie.service.Service Service;
    @RequestMapping("/earning")
    public String earning(Model model) throws SQLException {

        //盈利总金额

        double v = EarningService.sumEarning();
        double earning=v;
        //人数
        int userNum = EarningService.getUserNum();
        int count=userNum;

        //电影总量
        int videoCount = Service.getVideoCount();
        int looked=videoCount;
        model.addAttribute("earning",earning);
        model.addAttribute("count",count);
        model.addAttribute("looked",looked);
        //月份1-8
        double y1=EarningService.getMonthEarning(0,1);
        double y2=EarningService.getMonthEarning(1,2);
        double y3=EarningService.getMonthEarning(2,3);
        double y4=EarningService.getMonthEarning(3,4);
        double y5=EarningService.getMonthEarning(4,5);
        double y6=EarningService.getMonthEarning(5,6);
        double y7=EarningService.getMonthEarning(6,7);
        double y8=EarningService.getMonthEarning(7,8);

        model.addAttribute("y1",y1);
        model.addAttribute("y2",y2);
        model.addAttribute("y3",y3);
        model.addAttribute("y4",y4);
        model.addAttribute("y5",y5);
        model.addAttribute("y6",y6);
        model.addAttribute("y7",y7);
        model.addAttribute("y8",y8);
        return  "earning";
    }
}
