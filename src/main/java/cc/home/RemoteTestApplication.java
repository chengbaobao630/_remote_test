package cc.home;

import cc.home.jobber.CcScheduledThreadPoolExecutor;
import cc.home.jobber.TaskConfig;
import cc.home.jobber.TaskEngine;
import cc.home.jobber.spring.MyBeanPostProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;


@SpringBootApplication
@EnableJms
//@ImportResource({"classpath:spring-dubbo.xml"})
//@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class})})
public class RemoteTestApplication {


    public CcScheduledThreadPoolExecutor getThreadPoolExecutor() {
        return
                new CcScheduledThreadPoolExecutor(4);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("cc");
    }


    @Bean
    public TaskEngine taskEngine(){
        TaskConfig taskConfig=new TaskConfig();
        taskConfig.setJobDelayTime(30);
        return TaskEngine.build(taskConfig,getThreadPoolExecutor());
    }

    @Bean
    public ObjectMapper mapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper;
    }

    @Bean
    public MyBeanPostProcessor postProcessor(){
        return new MyBeanPostProcessor();
    }



    public static void main(String[] args) {
        SpringApplication.run(RemoteTestApplication.class, args);
    }
}
