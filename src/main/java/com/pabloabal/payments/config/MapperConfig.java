package com.pabloabal.payments.config;

import com.pabloabal.payments.mapper.PaymentMapper;
import com.pabloabal.payments.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapper userMapper(){
        return Mappers.getMapper(UserMapper.class);
    }

    @Bean
    public PaymentMapper paymentMapper(){
        return Mappers.getMapper(PaymentMapper.class);
    }

}
