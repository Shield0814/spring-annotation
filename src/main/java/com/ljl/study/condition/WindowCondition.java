package com.ljl.study.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowCondition implements Condition{

    @Override
    public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
        Environment environment = arg0.getEnvironment();
        ConfigurableListableBeanFactory beanFactory = arg0.getBeanFactory();
        BeanDefinitionRegistry registry = arg0.getRegistry();
        String osName = environment.getProperty("os.name");
        return osName.contains("Windows");
    }

}
