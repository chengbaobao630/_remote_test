package cc.home.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;

/**
 * Created by cheng on 2017/1/18 0018.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.DEFAULT)
@Lazy
public class HttpSessionWrapper implements HttpSession{

    @Autowired
    HttpSession httpSession;


    @Override
    public long getCreationTime() {
        return httpSession.getCreationTime();
    }

    @Override
    public String getId() {
        return httpSession.getId();
    }

    @Override
    public long getLastAccessedTime() {
        return httpSession.getLastAccessedTime();
    }

    @Override
    public ServletContext getServletContext() {
        return httpSession.getServletContext();
    }

    @Override
    public void setMaxInactiveInterval(int i) {
        httpSession.setMaxInactiveInterval(i);
    }

    @Override
    public int getMaxInactiveInterval() {
        return httpSession.getMaxInactiveInterval();
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return httpSession.getSessionContext();
    }

    @Override
    public Object getAttribute(String s) {
        return httpSession.getAttribute(s);
    }

    @Override
    public Object getValue(String s) {
        return httpSession.getValue(s);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return httpSession.getAttributeNames();
    }

    @Override
    public String[] getValueNames() {
        return httpSession.getValueNames();
    }

    @Override
    public void setAttribute(String s, Object o) {
        httpSession.setAttribute(s,o);
    }

    @Override
    public void putValue(String s, Object o) {
        httpSession.putValue(s, o);
    }

    @Override
    public void removeAttribute(String s) {
        httpSession.removeAttribute(s);
    }

    @Override
    public void removeValue(String s) {
        httpSession.removeValue(s);
    }

    @Override
    public void invalidate() {
        httpSession.invalidate();
    }

    @Override
    public boolean isNew() {
        return httpSession.isNew();
    }
}
