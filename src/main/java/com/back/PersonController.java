package com.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    private PersonService personService = new PersonService();


    @GetMapping("/people")
    public void people() {
        System.out.println("people");
    }


}
