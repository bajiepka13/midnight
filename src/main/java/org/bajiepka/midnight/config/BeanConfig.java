package org.bajiepka.midnight.config;

import org.bajiepka.midnight.domain.entity.Record;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "record")
    Record record() {
        return new Record();
    }

}
