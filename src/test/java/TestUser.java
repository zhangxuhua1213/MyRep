import com.entity.KamiCat;
import com.service.KamiCatService;
import com.service.KamiService;
import com.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    @Test
    public void getStudentByName(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContxtSSM.xml");
        KamiService sm=(KamiService)ac.getBean("kamiService");
//        boolean f=sm.checkUserIsRegister("zxh","111");
//        System.out.println(f);
//        Integer num = sm.getActiveRecordCount((long)670968);
//        int i=sm.getActiveRecord((long)670968,0,10).size();
//        System.out.println(num+"  "+i);

    }


}
