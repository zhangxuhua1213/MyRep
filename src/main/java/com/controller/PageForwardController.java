package com.controller;
import com.entity.Config;
import com.result.IndexMode;
import com.service.ConfigService;
import com.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageForwardController {

    @Autowired
    private ConfigService configService;
    @Autowired
    private IndexService indexService;
    @RequestMapping(value="page")
    public String gotoPage(@RequestParam String uri,Integer kid, HttpSession session){

        if(uri.equals("addKami")){
            List<Config> list=configService.getSelectOption();
            Map<String,String> strmap=new HashMap<>();
            if(list!=null&&list.size()>0) {
                Config config=list.get(0);
                int yueka=Integer.valueOf(config.getYueka());
                strmap.put("月卡扣"+yueka+"积分",String.valueOf(yueka)+",月卡");
                int jika=Integer.valueOf(config.getJika());
                strmap.put("季卡扣"+jika+"积分",String.valueOf(jika)+",季卡");
                int nianka=Integer.valueOf(config.getNianka());
                strmap.put("年卡扣"+nianka+"积分",String.valueOf(nianka)+",年卡");
                int zhongshen=Integer.valueOf(config.getZhongshenka());
                strmap.put("终身卡扣"+zhongshen+"积分",String.valueOf(zhongshen)+",终身卡");
            }
            System.out.println(list.size());
            session.setAttribute("strmap",strmap);
        }else if(uri.equals("index")){
            Long id=(long)session.getAttribute("id");
            IndexMode indexMode=new IndexMode();
            indexMode.setTotalRegister(indexService.getTotalRegister(id));
            indexMode.setTodayRegisterNums(indexService.getTodayRegisterNums(id));
            indexMode.setTodayChargNums(indexService.getTodayChargNums(id));
            indexMode.setYestodayRegisterNums(indexService.getYestodayRegisterNums(id));
            indexMode.setYestodayChargNums(indexService.getYestodayChargNums(id));
            indexMode.setWeekRegisterNums(indexService.getWeekRegisterNums(id));
            indexMode.setMonthRegisterNums(indexService.getMonthRegisterNums(id));
            session.setAttribute("indexMode", indexMode);
        }else if(uri.contains("listKamiByKid")){
            System.out.println("listKamiByKid:"+kid);
            session.setAttribute("kid", kid);
        }
        return uri;
    }
}
