package com.nchu.anti_japan_history;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.nchu.anti_japan_history.*.mapper"})
public class AntiJapanhistoryApplication {

    public static void main(String[] args) {

        SpringApplication.run(AntiJapanhistoryApplication.class, args);
    }

}
