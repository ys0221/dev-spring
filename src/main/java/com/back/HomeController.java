package com.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private PersonService personService = new PersonService();

    @GetMapping("/home")
    @ResponseBody
    public String people() {
        return "사람 수: %d".formatted(personService.count());
    }
}
