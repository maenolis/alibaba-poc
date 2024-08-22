package com.baeldung;

import java.util.function.Consumer;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.Message;
import org.springframework.web.client.RestTemplate;

import com.baeldung.dto.RocketMessageDto;

import io.seata.spring.annotation.GlobalTransactionScanner;

@Configuration
public class CompanyManagementConfiguration {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Consumer<Message<RocketMessageDto>> consumer() {
        return msg -> {
            LOG.info("Got msg: {}", msg);
        };
    }

    @Bean
    @Primary
    public static GlobalTransactionScanner globalTransactionScanner(){
        return new GlobalTransactionScanner("company-mgmt-tx-group");
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
