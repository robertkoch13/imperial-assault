package com.robertkoch.imperialassault.web.config;

import com.robertkoch.imperialassault.services.config.ServicesConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by robert.koch on 2017/02/16.
 */
@Configuration
@Import({ServicesConfig.class})
public class RootConfig {
}
