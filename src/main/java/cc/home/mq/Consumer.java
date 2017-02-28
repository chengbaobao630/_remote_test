package cc.home.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by cheng on 2017/2/28 0028.
 */
@Component
public class Consumer {


    @JmsListener(destination = "cc")
    public void receiveQueue(String text) {
        System.out.println(text);
    }
}
