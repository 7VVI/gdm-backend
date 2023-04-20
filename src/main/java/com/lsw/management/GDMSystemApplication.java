package com.lsw.management;

import com.lsw.management.common.util.sychronize.annotation.EnableSync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAsync
@EnableSync(basePackage = "com.lsw.management.admin.model.po")
@SpringBootApplication
public class GDMSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GDMSystemApplication.class, args);
    }

}
