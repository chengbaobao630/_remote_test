package org.springframework.beans.factory.support;

import cc.home.exporter.Exporter;
import cc.home.exporter.ExporterChildDemo;
import cc.home.exporter.ExporterDemo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.HashSet;
import java.util.List;

/**
 * Created by cheng on 2017/2/13 0013.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    private DefaultListableBeanFactory beanFactory;

    public MyBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Exporter exporter = bean.getClass().getAnnotation(Exporter.class);
        if (exporter != null) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(
                    ExporterChildDemo.class)
                    .setScope(BeanDefinition.SCOPE_SINGLETON)
                    .setAutowireMode(AbstractBeanDefinition.AUTOWIRE_NO)
                    .setInitMethodName("init")
                    .setParentName(ExporterDemo.class.getSimpleName())
                    .getBeanDefinition();
            /*
            beanFactory.createBean(String.format("exporter.S", beanName), beanDefinition);
            beanFactory.createbean*/
            beanFactory.registerBeanDefinition(String.format("exporter.S", beanName), beanDefinition);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }



    public static void removeDuplicate1(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list);
    }

    public static void removeDuplicate2(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        System.out.println(list);
    }

}
