package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @PostMapping("/register")
    public void postUser(@RequestBody User user){ /*спринг сам положит переданные поля в объект(стоит проверить)*/
        //необходимо проверка на оригинальность email
        //пароли нужно шифровать
    }
}
