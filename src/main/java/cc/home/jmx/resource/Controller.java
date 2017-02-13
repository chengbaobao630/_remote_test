package cc.home.jmx.resource;

import cc.home.jmx.mbean.User;

import javax.management.*;
import javax.swing.*;
import java.lang.management.ManagementFactory;

/**
 * Created by cheng on 2017/2/3 0003.
 */
public class Controller implements ControllerMBean {

    private User user;

    @Override
    public void setName(String name) {
        user.setName(name);
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public String status() {
        return "this is a Controller MBean,name is " + user.getName();
    }

    @Override
    public void start() {
        this.user = new User();
        user.setName("cc");
    }

    @Override
    public void stop() {
        //TODO
    }

    public static void main(String[] args)
            throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException {
        //获得MBeanServer实例
//      MBeanServer mbs = MBeanServerFactory.createMBeanServer();//不能在jconsole中使用
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();//可在jconsole中使用
        //创建MBean
        ControllerMBean controller = new Controller();
        //将MBean注册到MBeanServer中
        mbs.registerMBean(controller, new ObjectName("MyappMBean:name=controller"));

       /* //创建适配器，用于能够通过浏览器访问MBean
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        adapter.setPort(9797);
        mbs.registerMBean(adapter, new ObjectName(
                "MyappMBean:name=htmladapter,port=9797"));
        adapter.start();
*/
        //由于是为了演示保持程序处于运行状态，创建一个图形窗口
        javax.swing.JDialog dialog = new JDialog();
        dialog.setName("jmx test");
        dialog.setVisible(true);
    }
}
