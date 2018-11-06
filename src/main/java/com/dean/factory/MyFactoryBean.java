package com.dean.factory;

import com.dean.domain.People;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author: Dean
 * @Date: 2018/11/5 16:54
 * @Description:
 */
public class MyFactoryBean extends AbstractFactoryBean<Object> {

    @Override
    public Class<?> getObjectType() {
        System.out.println("enter MyFactoryBean getObjectType...");
        return People.class;
    }

    @Override
    protected Object createInstance() throws Exception {
        System.out.println("enter MyFactoryBean createInstance...");
        return new People("factoryDemo", 18);
    }

    @Override
    public String toString() {
        return "MyFactoryBean.tostring() {}";
    }
}
