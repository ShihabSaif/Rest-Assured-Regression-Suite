package com.example.restassuredproject.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
@Configuration
@PropertySource("classpath:application.properties")
public class ReadFromPropertiesFile {


    public String getPropertyKeyVariable() {
        return propertyKeyVariable;
    }

    public void setPropertyKeyVariable(String propertyKeyVariable) {
        this.propertyKeyVariable = propertyKeyVariable;
    }


    @Value("${spring.config.import}")
    private String propertyKeyVariable;




    @Value("${spring.app.nidNo}")
    private String appNidNo;

    private String anotherVar;

    @PostConstruct
    public String postConstruct(){

       return appNidNo; // <-- using myVar after the bean construction
    }



}
