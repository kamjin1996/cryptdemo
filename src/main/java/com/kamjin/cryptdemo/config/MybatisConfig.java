package com.kamjin.cryptdemo.config;

import com.github.kamjin1996.mybatis.intercept.crypt.CryptInterceptor;
import com.github.kamjin1996.mybatis.intercept.crypt.config.AesEnum;
import com.github.kamjin1996.mybatis.intercept.crypt.config.Dbcrypt;
import lombok.Data;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置
 *
 * @author kamjin1996
 */
@Configuration
@MapperScan("com.kamjin.cryptdemo.mapper")
@Data
public class MybatisConfig {

    @Value("${dbcrypt.secretkey}")
    private String secretkey;

    @Value("${dbcrypt.enable}")
    private boolean enable;

    @Bean
    public CryptInterceptor cryptInterceptor() {
        return new CryptInterceptor();
    }

    @Bean
    public Dbcrypt dbcrypt() {
        return new Dbcrypt(AesEnum.AES192, getSecretkey(), isEnable());
    }
}
