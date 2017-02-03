package cc.home.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by cheng on 2017/1/18 0018.
 */
@WebListener
public class MySessionListener implements HttpSessionListener,HttpSessionAttributeListener {



    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        httpSessionBindingEvent.getName();
        httpSessionBindingEvent.getValue();
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
