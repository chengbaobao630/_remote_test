package cc.home;

import cc.home.jobber.CcScheduledThreadPoolExecutor;
import cc.home.jobber.TaskConfig;
import cc.home.jobber.TaskEngine;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ImportResource({"classpath:spring-dubbo.xml"})
//@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Service.class})})
public class RemoteTestApplication {


    public CcScheduledThreadPoolExecutor getThreadPoolExecutor() {
        return
                new CcScheduledThreadPoolExecutor(4);
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

    public static void main(String[] args) {
        SpringApplication.run(RemoteTestApplication.class, args);
    }
}
