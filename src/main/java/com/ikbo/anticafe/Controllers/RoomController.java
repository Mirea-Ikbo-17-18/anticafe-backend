package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Room;
import com.ikbo.anticafe.Repositorys.RoomRepository;
import com.ikbo.anticafe.Services.Room.RoomService;
import com.ikbo.anticafe.Services.Room.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomRepository roomRepository, RoomService roomService) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<View.ViewRoom> getRooms(){
        return roomService.getElements();
    }

    @GetMapping("/roomtime")
    public void getRoomTime(@RequestBody Integer idRoom) { /*возможно взаимодействие с id по url(мысли в текст)*/
        //Room room = this.roomRepository.findById((long) id).get();

        //day: str //format "yyyy-mm-dd"
        //...

        //times: [int] //Часы, которые доступны для бронирования(по типу [9, 10, 12, 13])
        roomService.getTimes(idRoom);

    }

    @PatchMapping("/room")
    public Room patchRoom(@RequestBody Room room){
        this.roomRepository.save(room);
        return room;
    }

}
