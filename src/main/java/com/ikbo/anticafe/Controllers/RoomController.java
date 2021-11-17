package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Room;
import com.ikbo.anticafe.Repositorys.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return (List<Room>)roomRepository.findAll();
    }

    @GetMapping("/roomtime")
    public void/*тип неясен*/ getRoomTime(@RequestBody Room room){ /*возможно взаимодействие с id по url(мысли в текст)*/

    }

    @PatchMapping("/room")
    public void patchRoom(@RequestBody Room room){

    }


}
