package org.truenewx.tnxsample.admin.web.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.config.WebViewMvcConfigurationSupport;
import org.truenewx.tnxjee.web.view.menu.factory.MenuFactory;
import org.truenewx.tnxjee.web.view.menu.factory.MenuFactoryBean;
import org.truenewx.tnxjee.web.view.menu.factory.MenuFactoryImpl;
import org.truenewx.tnxjee.web.view.menu.model.Menu;
import org.truenewx.tnxjee.web.view.menu.provider.MenuProvider;
import org.truenewx.tnxjee.web.view.menu.provider.MenuProviderImpl;
import org.truenewx.tnxjee.web.view.sitemesh.config.BuildableSiteMeshFilter;

@Configuration
public class WebMvcConfig extends WebViewMvcConfigurationSupport {

    @Bean
    public FilterRegistrationBean<BuildableSiteMeshFilter> siteMeshFilter() {
        return super.siteMeshFilter(builder -> {
            builder.addExcludedPath("**/*.json");
            builder.addDecoratorPath("/*", "/decorator/default.jsp");
        });
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
