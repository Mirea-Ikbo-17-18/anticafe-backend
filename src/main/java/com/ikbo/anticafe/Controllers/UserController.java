package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Reservation;
import com.ikbo.anticafe.Models.User;
import com.ikbo.anticafe.Repositorys.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @AllArgsConstructor
    public static class UserReqData { //было не static
        public String firstName;
        public String lastName;
        public String email;
        public String number;
    }

    @GetMapping("/user")
    public UserReqData getUser(){
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());

        //имя текущего пользователя(владельца сессии)
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(authentication.getName()); //user@mail.com
        //System.out.println(authentication.getPrincipal()); //[Username=user@mail.com, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[developers:read]]

        return new UserReqData(user.get().getFirstname(), user.get().getLastname(), user.get().getEmail(), user.get().getNumber());
    }


    @PatchMapping("/users")
    public void patchUser(@RequestBody User updatedUser){
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        User updatedUserTemp = user.get();

        updatedUserTemp.setFirstname(updatedUser.getFirstname());
        updatedUserTemp.setLastname(updatedUser.getLastname());
        updatedUserTemp.setNumber(updatedUser.getNumber());

        userRepository.save(updatedUserTemp);
    }



}
