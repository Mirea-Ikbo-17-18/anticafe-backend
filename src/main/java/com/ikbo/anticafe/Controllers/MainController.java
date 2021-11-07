package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Model.User;
import com.ikbo.anticafe.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
