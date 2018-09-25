package com.controller;

import com.Utils.CreateKaMi;
import com.Utils.TimeUitils;
import com.entity.Kami;
import com.entity.KamiCat;
import com.entity.Kamilist;
import com.result.ActiveRecord;
import com.service.KamiCatService;
import com.service.KamiService;
import com.service.KamilistService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KamiController {
    @Autowired
    private KamilistService kamilistService;
    @Autowired
    private KamiService kamiService;
    @Autowired
    private UserService userService;

    @Autowired
    private KamiCatService kamiCatService;
    @ResponseBody
    @RequestMapping(value = "kamiuserList")
    public Map<String,Object> getKamiUser(HttpSession session){
        Long userid =(long)session.getAttribute("id");
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","sucess");
       // map.put("count",);
        map.put("data",kamilistService.selectKamiListAndUser(userid));
        return map;
    }
//激活记录
    @ResponseBody
    @RequestMapping(value = "getActiveRecord")
    public Map<String,Object> getActiveRecord(HttpSession session,Integer page,Integer limit,String keyword){
        Long id=(long)session.getAttribute("id");
        if(keyword.trim()==""){
            keyword=null;
        }
        System.out.println("id:"+id+" page:"+page+" limit:"+limit+" keyword:"+keyword);
        Integer start=limit*(page-1);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","sucess");
        map.put("count",kamiService.getActiveRecordCount(id,keyword));
        map.put("data",kamiService.getActiveRecord(id,start,limit,keyword));
        return map;

    }

//    //getActiveRecordByHuiyuan
//    @ResponseBody
//    @RequestMapping(value = "getActiveRecordByHuiyuan")
//    public Map<String,Object> getActiveRecord(Long id,Integer page,Integer limit,Integer huiyuan){
//        System.out.println("id:"+id+" page:"+page+" limit:"+limit+" huiyuan"+huiyuan);
//        kamiService.
//        return null;
//
//    }

    @ResponseBody
    @RequestMapping(value = "listKamiByKid")
    public Map<String,Object> getListKamiByKid(Integer kid){
        System.out.println("kid:"+kid);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","sucess");
       // System.out.println("getListKamiByKid:"+kamiService.getListKamiByKid(kid).size());
        map.put("data", kamiService.getListKamiByKid(kid));
        return map;

    }
    /**
     *
     * @param nums 数量
     * @param pointsAndType 扣除的积分和名字，如1,月卡
     * @param session
     */
    @RequestMapping(value = "addKami")
    public String addKami(Integer nums, String pointsAndType,HttpSession session){
        Long uid=(Long)session.getAttribute("id");//用户id
        if(nums!=null&&nums>0&&pointsAndType!=null&&uid!=null){
            int points=Integer.valueOf(pointsAndType.split(",")[0]);
            String cname=pointsAndType.split(",")[1];
            Integer monthcardNums=userService.getMothCardNumsById(uid);
            System.out.println("nums: "+nums+" points: "+points+" userid:"+uid+" monthcardNums:"+monthcardNums+" cname"+cname
            +"points:"+points);
            if((nums*points)<=monthcardNums){
                KamiCat kamiCat=kamiCatService.getKamiCatByNmae(cname);
                int cid=kamiCat.getId();
                System.out.println("cid:"+cid);
                //插入kamilist得到id
                Kamilist kamilist=new Kamilist();
                kamilist.setNums(nums);
                kamilist.setUid(uid.intValue());//Integer.parseInt(String.valueOf(uid))
                kamilistService.insertKamilist(kamilist);
                System.out.println("kid:"+kamilist.getId());
                int kid=kamilist.getId();
                while (nums>0){
                    //插入kami
                    //生成code
                    String code= CreateKaMi.create();
                    Kami kami=new Kami();
                    kami.setCode(code);
                    kami.setCreatetime(TimeUitils.currentTimeToString());
                    kami.setKid(kid);
                    kami.setStatus((byte)0);
                    kami.setMoney("0");
                    kami.setTouid(uid.intValue());
                    kami.setCid(cid);
                    kami.setType((byte)cid);
                    kami.setMonth(kamiCat.getMonth());
                    kamiService.insertKami(kami);
                    //扣除积分并更新
                    monthcardNums=monthcardNums-(nums*points);
                    userService.updateMonthcardnumsById(uid,monthcardNums);
                    nums--;
                }
                return "success";
            }else {
                System.out.println("积分不够");
                return "error";
            }


        }else{
            System.out.println("输入参数错误或无登录用户id");
            return "error";
        }

    }
}
