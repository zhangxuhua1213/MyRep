import com.Utils.TimeUitils;
import com.entity.Users;
import com.service.KamiCatService;
import com.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestStream {
    public static void main(String[] args){
        List<Users> list=new ArrayList<>();
//        Users user1=new Users();
//        user1.setId((long)1);
//        user1.setCreateTime(new Date(2018,9,21));
//        Users user2=new Users();
//        user2.setId((long)2);
//        user2.setCreateTime(new Date(2018,9,20));
//        Users user3=new Users();
//        user3.setId((long)3);
//        user3.setCreateTime(new Date(2018,9,17));
//        Users user4=new Users();
//        user4.setId((long)4);
//        user4.setCreateTime(new Date(2018,9,16));
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        list.add(user4);
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContxtSSM.xml");
        UserService sm=(UserService)ac.getBean("userService");
//        list=sm.getUserLsit(0,100);
//        System.out.println("list:"+list.size());
//        List<Users> collet1=list.stream()
//                .filter(user -> (daysBetween(user.getCreateTime(),new Date()))<=1 )
//                .collect(Collectors.toList());
//        System.out.println(collet1.size());
//        for(Users user:list){
//            int days=daysBetween(user.getCreateTime(),new Date());
//            if(days==0){
//
//            }else if(days==1){
//
//            }
//        }
    }
    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate)
    {
        long between_days=0;
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            smdate=sdf.parse(sdf.format(smdate));
            System.out.println("smdate"+smdate);
            bdate=sdf.parse(sdf.format(bdate));
            System.out.println("bdate"+bdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            between_days=(time2-time1)/(1000*3600*24);
        }catch (Exception e){

        }


        return Integer.parseInt(String.valueOf(between_days));
    }
}
