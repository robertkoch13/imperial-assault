package com.robertkoch.imperialassault.services.config;

import com.robertkoch.imperialassault.persistence.config.JPAConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * Created by robert.koch on 2017/02/15.
 */
@Configuration
@ComponentScan(
        basePackages = "com.robertkoch.imperialassault.services",
        includeFilters = @ComponentScan.Filter(Service.class)
)
@Import({
        JPAConfig.class
})
public class ServicesConfig {
}
