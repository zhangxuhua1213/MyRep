package com.controller;

import com.Utils.HTTPUtils;
import com.Utils.MD5;
import com.entity.Config;
import com.entity.Users;
import com.result.JifenRecord;
import com.service.ConfigService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    final String fixstr="rCt52pF2cnnKNB3Hkp";//固定字符串
    final String result="###";
    @Autowired
    private UserService userService;

    @Autowired
    private ConfigService configService;

    @RequestMapping(value="login",method= RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) throws Exception{
        //System.out.println("开始验证用户名和密码");
        String md5Password=null;
        try {
            md5Password = HTTPUtils.getPasswordByOutHttpRequest(null,password);
        }catch (Exception e){
            //System.out.println("md5出错");
        }
        Long uesrId=userService.checkUserIsRegister(username,md5Password);
        if(uesrId!=null){
            //System.out.println("存在该用户，登录成功！");
            session.setAttribute("username",username);
            session.setAttribute("id",uesrId);//获取当前用户id
            session.setAttribute("login",MD5.EncoderByMd5(username));
            return "admin";
        }else{
           // System.out.println("不存在该用户，登录失败！");
            return "error";
        }

    }
    //当前用户的下级代理
    @ResponseBody
    @RequestMapping(value="userList")
    public Map<String,Object> getUserLsit(Integer page,Integer limit,HttpSession session){

        Long id=(long)session.getAttribute("id");
        //System.out.println("请求list,page="+page+" limit"+limit+" id:"+id);
        Integer start=limit*(page-1);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","sucess");
        map.put("count",userService.getCount(id));
        List<Users> list=userService.getUserLsit(start,limit,id);
        for(Users user:list){
            Integer huiyuanNum=userService.getHuiyuanNumById(user.getId());
            //System.out.println("huiyuanNum:"+huiyuanNum);
            user.setHuiyuanNum(huiyuanNum);
        }
        map.put("data",list);
        return map;
    }

    //新增代理
    @RequestMapping(value = "insertUser",method= RequestMethod.POST)
    public String regsiterUser(Users user)throws Exception{
       // System.out.println(user.toString());
        String oldPas=user.getUserPass();
        String newPas=HTTPUtils.getPasswordByOutHttpRequest(null,oldPas);
      //  System.out.println("newPas:"+fixstr);
        user.setUserPass(newPas);
        userService.insertUser(user);
        return "success";
    }
    @ResponseBody
    @RequestMapping(value = "myExtend")
    public Map<String,Object> getMyExtend(@RequestParam Long id){
        //System.out.println("获取到的id="+id);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","sucess");
        map.put("count",userService.getUserCountByInviter(id));
        map.put("data",userService.getUserListByInviter(id));
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "jifenList")
    public Map<String,Object> getJifenRecord(Integer page,Integer limit,HttpSession session){
       // System.out.println("getJifenRecord,page="+page+" limit"+limit);
        Long id=(long)session.getAttribute("id");
        Integer start=limit*(page-1);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","sucess");
        map.put("count",userService.getCount(id));
        map.put("data",userService.getJifenRecord(start,limit));
        return map;
    }


    @ResponseBody
    @RequestMapping(value = "updateDailiMonthcardnums",method = RequestMethod.POST)
    public Map<String,Object> updateDailiMonthcardnumsByid(Long id ,Integer monthcardnums){
        //System.out.println("id:"+id+" monthcardnums:"+monthcardnums);
        Map<String,Object> map=new HashMap<>();
        if(monthcardnums<0||!(monthcardnums instanceof Integer)){
            map.put("value",2);
            map.put("msg","输入参数不合法！");
            return map;
        }
        //更新操作
        Integer currentNums=userService.getMothCardNumsById(id);
        monthcardnums=currentNums+monthcardnums;
        userService.updateMonthcardnumsById(id,monthcardnums);

        map.put("value",1);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "resetDaili",method = RequestMethod.POST)
    public Map<String,Object> resetDailiById(HttpSession session,Users user){
        //System.out.println(user.getMobile()+" "+user.getYuekaUrl());
        Map<String,Object> map=new HashMap<>();
        Long id=(long)session.getAttribute("id");
       // System.out.println("resetDailiById:"+id);
        user.setId(id);
        userService.updateByPrimaryKeySelective(user);
        map.put("value",1);
        return map;
    }

}
