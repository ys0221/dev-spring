package com.back;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional// 선언해주면 personService 프록시를 받는다
    public int count() {
        return personRepository.count();
    }
}