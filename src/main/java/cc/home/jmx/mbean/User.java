package cc.home.jmx.mbean;

/**
 * Created by cheng on 2017/2/3 0003.
 */
public class User {

    private String name;

    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
