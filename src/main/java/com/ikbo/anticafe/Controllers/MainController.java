package com.ikbo.anticafe.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/main")
    public String getAll(){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(authentication.getName()); //user@mail.com
        //System.out.println(authentication.getPrincipal()); //[Username=user@mail.com, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[developers:read]]
        return "Hello";
    }
}
