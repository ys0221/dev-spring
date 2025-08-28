package com.back;

import org.springframework.stereotype.Component;

@Component // 객체를 만들어서 Bean 으로 등록
// 하지만 단순 선언 -> 복잡한 처리, 객체 생성 로직을 적용할 수는 없음
// 안되면 그냥 @Bean 선언
public class PersonService {
    public int count() {
        return 3;
    }
}
