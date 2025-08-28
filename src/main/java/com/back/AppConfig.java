package com.back;

import org.springframework.context.annotation.Configuration;

// spring 시작할 때 초기 작업
@Configuration // 무언가를 설정하는 클래스
public class AppConfig {

    /*
    component 선언해주면 필요 없는 과정!
    @Bean // 객체를 저장소에 담는다
    public PersonService personService() {
        System.out.println("AppConfig,personService 호출됨");
        return new PersonService(); // 객체 하나 생 - 스프링이 저장해둠
    }

     */


}
