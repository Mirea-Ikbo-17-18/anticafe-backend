package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Reservation;
import com.ikbo.anticafe.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    /*@GetMapping("/user")
    public User getUser(){
        //имя текущего пользователя(владельца сессии)
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(authentication.getName()); //user@mail.com
        //System.out.println(authentication.getPrincipal()); //[Username=user@mail.com, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[developers:read]]

        return ;
    }*/

    @PatchMapping("/users")
    public void patchUser(@RequestBody User updatedUser){

    }

    /*@GetMapping("/reservations")
    public List<Reservation>*//*тип неясен*//* getUserReservation(){
        return ;
    }*/

    @PostMapping("/reservation")
    public void postReservation(@RequestBody Reservation reservation){

    }

    @DeleteMapping("/reservation")
    public void deleteReservation(@RequestBody Reservation reservation){

    }

    /*@GetMapping("/allreservations")
    public List<Reservation> getAllReservations(){
        return ;
    }*/


}
