package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
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
