package ru.netology.SpringBootConditionalApplication.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.SpringBootConditionalApplication.profiles.DevProfile;
import ru.netology.SpringBootConditionalApplication.profiles.ProductionProfile;
import ru.netology.SpringBootConditionalApplication.profiles.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty (value="netology.profile.dev", havingValue="false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}
