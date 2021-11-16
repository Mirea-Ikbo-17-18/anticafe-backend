package com.ikbo.anticafe.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/statistics")
    public void/*тип неясен*/ getStatistic(){

    }
}
