package com.github.kamjin1996.mybatisplusdemo.config;

import com.kamjin.toolkit.db.crypt.core.bean.DbcryptProperties;
import com.kamjin.toolkit.db.crypt.core.enums.AesEnum;
import com.kamjin.toolkit.db.crypt.mybatisplus.interceptor.MybatisPlusCryptInterceptor;
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
@MapperScan("com.github.kamjin1996.mybatisplusdemo.mapper")
@Data
public class MybatisConfig {

    @Value("${dbcrypt.secretkey}")
    private String secretkey;

    @Value("${dbcrypt.enable}")
    private boolean enable;

    @Value("${dbcrypt.primaryKeyName}")
    private String primaryKeyName;

    @Bean
    public MybatisPlusCryptInterceptor mybatisPlusCryptInterceptor() {
        return new MybatisPlusCryptInterceptor(new DbcryptProperties(AesEnum.AES192, getSecretkey(), isEnable(), getPrimaryKeyName()));
    }

}
