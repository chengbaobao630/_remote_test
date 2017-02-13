package cc.home;

import cc.home.exporter.TestExporter;
import cc.home.exporter.TestExporterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * Created by cheng on 2017/2/10 0010.
 */
@Configuration
public class MyExporterConfig {


    @Bean("/exporter")
    public TestExporterImpl testExporter(){
        return new TestExporterImpl();
    }


    @Bean("/cc.home.exporter1")
    public HttpInvokerServiceExporter invokerServiceExporter(){
        HttpInvokerServiceExporter exporter=new HttpInvokerServiceExporter();
        exporter.setService(testExporter());
        exporter.setServiceInterface(TestExporter.class);
        return exporter;
    }
}
