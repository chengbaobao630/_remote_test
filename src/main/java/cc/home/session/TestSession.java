package cc.home.session;

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
}
