package com.ikbo.anticafe.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafe")
public class MainController {

    @GetMapping("/main")
    public String getAll(){
        return "Hello";
    }
}
