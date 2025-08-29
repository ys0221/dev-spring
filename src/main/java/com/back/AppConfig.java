package com.back;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    // 왜 lazy 와 self 를 사용해야하는가?
    // final 로 하면 계속 순환 -> 본인을 만들기 위해 본인이 필요함
    // 그래서 생성자로 받지 않고(final X) autowired 선언(얘는 생성할 때 안 받음)
    // 근데 Autowired 만 선언(필드 입력 받는다)해준다고 해결되는건 아님
    // new AppConfig.self = new AppConfig() 가 반복

    // lazy 가 해결해줌
    // 프록시는 리얼이 갖고 있는 기능을 다 갖고 있어야함 -> 진짜에 work1 이 있으면 프록시에도 work1이 있어야함
    // @Lazy - 프록시로 만들어주는 역할
    // self 가 진짜에 존재 -> lazy 로 선언 -> 프록시에도 self 를 만든다
    // 모든 객체는 this 를 갖고 있음 = 자기 자신을 가리킴 -> self 를 빼면 기본으로 this 가 붙어있음
    // 프록시에서 this -> 진짜의 self 를 가리킨다

    @Autowired
    @Lazy
    private AppConfig self;

    @Bean
    public ApplicationRunner myApplicationRunner3() {
        return args -> {
                // 리얼 객체의 메서드 호출
                this.work1();
                this.work2();

                // 프록시 객체의 메서드 호출
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
