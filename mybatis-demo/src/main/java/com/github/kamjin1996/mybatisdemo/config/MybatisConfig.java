package com.github.kamjin1996.mybatisdemo.config;

import com.kamjin.toolkit.db.crypt.core.bean.DbcryptProperties;
import com.kamjin.toolkit.db.crypt.core.enums.AesEnum;
import com.kamjin.toolkit.db.crypt.mybatis.interceptor.MybatisCryptInterceptor;
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
@MapperScan("com.github.kamjin1996.mybatisdemo.mapper")
@Data
public class MybatisConfig {

    @Value("${kamjin.dbcrypt.secretkey}")
    private String secretkey;

    @Value("${kamjin.dbcrypt.enable}")
    private boolean enable;

    @Value("${kamjin.dbcrypt.primaryKeyName}")
    private String primaryKeyName;

    @Bean
    public MybatisCryptInterceptor mybatisCryptInterceptor() {
        return new MybatisCryptInterceptor(new DbcryptProperties(AesEnum.AES192, getSecretkey(), isEnable(), getPrimaryKeyName()));
    }
}
