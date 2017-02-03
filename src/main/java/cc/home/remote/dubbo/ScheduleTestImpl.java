package cc.home.remote.dubbo;

import cc.home.controller.HelloCc;
import cc.home.controller.HelloCom;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import reomte.dubbo.ScheduleTest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by cheng on 2017/1/13 0013.
 */
@Service(version = "1.0.0")
@Path("schedule")
public class ScheduleTestImpl implements ScheduleTest {

    @Autowired
    HelloCc helloCc;

    @Autowired
    HelloCom helloCom;

    @Path("name")
    @GET
    public String schedule(String name) {

        return "success";
    }
}
