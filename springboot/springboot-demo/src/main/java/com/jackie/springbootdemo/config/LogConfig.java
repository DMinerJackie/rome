package com.jackie.springbootdemo.config;

import com.jackie.springbootdemo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public Person logMethod() {
        LOG.info("==========print log==========");
        return new Person();
    }
}
