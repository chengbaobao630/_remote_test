package cc.home.jmx.resource;

/**
 * Created by cheng on 2017/2/3 0003.
 */
public interface ControllerMBean {

    //属性
     void setName(String name);
     String getName();


    //操作
    /**
     * 获取当前信息
     * @return
     */
     String status();
     void start();
     void stop();
}
