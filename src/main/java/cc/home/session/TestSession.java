package cc.home.session;

import cc.home.jmx.mbean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cheng on 2017/1/18 0018.
 */
@RequestMapping("test")
@RestController
public class TestSession {

//    @Autowired
    HttpSessionWrapper httpSession;

    @RequestMapping("session")
    public String checkSession(){
        return httpSession.getId();
    }


    private static int times = 9;
    private static  Double l = 0d;

    public static void main(String[] args) {
        Double h = 100d;
        downUp(h);
        System.out.println(l);

        System.out.println(h);

        User user=new User();
        user.setName("cc");
        user.setPassword("123456");

        String userName= "cc";

        changeString(userName);

        changeName(user);

        System.out.println(user.getName());

        System.out.println(userName);
    }

    private static void changeString(String userName) {
        userName="dd";
    }

    private static void changeName(User user) {
        user.setName("dd");
    }

    private static void    downUp(Double h) {
        times --;
        l += h ;
        h = h /2;
        l += h;
        if (times > 1){
            downUp(h);
        }
    }






}
