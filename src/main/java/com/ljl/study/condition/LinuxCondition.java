package com.ljl.study.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition{

    @Override
    public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
        Environment environment = arg0.getEnvironment();
        String osName = environment.getProperty("os.name");
        return osName.contains("Linux");
        
    }

}
