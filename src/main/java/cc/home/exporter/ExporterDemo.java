package cc.home.exporter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by cheng on 2017/2/13 0013.
 */
@Component
public class ExporterDemo {

    @PostConstruct
    public void init(){
        System.out.println(this.getClass().getSimpleName());
    }
}
