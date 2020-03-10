package com.jean.aime.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                AppContext.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
