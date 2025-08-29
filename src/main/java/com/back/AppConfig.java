package com.back;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    @Autowired
    @Lazy
    private  AppConfig self; // final -> 생성자로만 주입 가능
    // final 없애고 autowired 로 필드 주입

    @Bean
    public ApplicationRunner myApplicationRunner3() {
        return args -> {
               self.work1();
               self.work2();
        };
    }

    @Transactional // myApplicationRunner3 에서 실행할 때 작동 안 됨
    // this 이용해서 자기 자신의 메서드 이용할 때는 transactional 사용 안 함
    public void work1() {
        System.out.println("work1");
    }

    @Transactional
    public void work2() {
        System.out.println("work2");
   }

}
