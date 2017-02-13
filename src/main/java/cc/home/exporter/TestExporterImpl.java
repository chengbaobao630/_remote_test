package cc.home.exporter;

/**
 * Created by cheng on 2017/2/10 0010.
 */
public class TestExporterImpl implements TestExporter {
    @Override
    public String sayHello(String name) {
        return "hello : " + name;
    }
}
