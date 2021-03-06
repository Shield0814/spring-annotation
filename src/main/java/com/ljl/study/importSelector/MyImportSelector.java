package com.ljl.study.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector{

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        
        return new String[]{"com.ljl.study.bean.Green","com.ljl.study.bean.Red"};
    }

}
