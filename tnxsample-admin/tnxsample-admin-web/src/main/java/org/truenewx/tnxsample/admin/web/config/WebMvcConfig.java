package org.truenewx.tnxsample.admin.web.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.truenewx.tnxjee.web.view.config.WebViewMvcConfigurationSupport;
import org.truenewx.tnxjee.web.view.menu.factory.MenuFactory;
import org.truenewx.tnxjee.web.view.menu.factory.MenuFactoryBean;
import org.truenewx.tnxjee.web.view.menu.factory.MenuFactoryImpl;
import org.truenewx.tnxjee.web.view.menu.model.Menu;
import org.truenewx.tnxjee.web.view.menu.provider.MenuProvider;
import org.truenewx.tnxjee.web.view.menu.provider.MenuProviderImpl;

@Configuration
public class WebMvcConfig extends WebViewMvcConfigurationSupport {

    @Override
    protected void buildSiteMeshFilter(SiteMeshFilterBuilder builder) {
        builder.addExcludedPath("/swagger-ui.html");
        builder.addExcludedPath("**/*.json");
        builder.addDecoratorPath("**/*.win", "/decorator/win.jsp");
        builder.addDecoratorPath("/*", "/decorator/default.jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public MenuFactory menuFactory() {
        return new MenuFactoryImpl();
    }

    @Bean
    public FactoryBean<Menu> menu() {
        return new MenuFactoryBean("admin");
    }

    @Bean
    public MenuProvider menuProvider(Menu menu) {
        return new MenuProviderImpl(menu);
    }

}
