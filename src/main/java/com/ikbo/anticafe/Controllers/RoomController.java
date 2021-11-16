package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class RoomController {
    /*@GetMapping("/rooms")
    public List<Room>*//*предположительный тип*//* getRooms(){

    }*/

    @GetMapping("/roomtime")
    public void/*тип неясен*/ getRoomTime(@RequestBody Room room){ /*возможно взаимодействие с id по url(мысли в текст)*/

    }

    @PatchMapping("/room")
    public void patchRoom(@RequestBody Room room){

    }


}
