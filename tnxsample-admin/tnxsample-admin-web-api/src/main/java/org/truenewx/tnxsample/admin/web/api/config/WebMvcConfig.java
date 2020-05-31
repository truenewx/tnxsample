package org.truenewx.tnxsample.admin.web.api.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.config.WebMvcConfigurerSupport;
import org.truenewx.tnxjee.web.menu.factory.MenuFactory;
import org.truenewx.tnxjee.web.menu.factory.MenuFactoryBean;
import org.truenewx.tnxjee.web.menu.factory.MenuFactoryImpl;
import org.truenewx.tnxjee.web.menu.model.Menu;
import org.truenewx.tnxjee.web.menu.provider.MenuProvider;
import org.truenewx.tnxjee.web.menu.provider.MenuProviderImpl;
import org.truenewx.tnxsample.common.CommonConstants;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerSupport {

    @Bean
    public MenuFactory menuFactory() {
        return new MenuFactoryImpl();
    }

    @Bean
    public FactoryBean<Menu> menu() {
        return new MenuFactoryBean(CommonConstants.USER_TYPE_MANAGER);
    }

    @Bean
    public MenuProvider menuProvider(Menu menu) {
        return new MenuProviderImpl(menu);
    }

}
