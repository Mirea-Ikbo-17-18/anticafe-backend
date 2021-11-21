package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Room;
import com.ikbo.anticafe.Repositorys.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private static class RoomReservationTime {
        public String day;
        public ArrayList<Integer> times;

        RoomReservationTime(String _day, ArrayList<Integer> _times) {
            this.day = _day;
            this.times = _times;
        }
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return (List<Room>)roomRepository.findAll();
    }

    // TODO: Для комнаты можно удалить Finish и Start колноки из таблицы

    @GetMapping(path = "/roomtime", params = {"id"})
    public RoomReservationTime getRoomTime(@RequestParam("id") Long id){ /*возможно взаимодействие с id по url(мысли в текст)*/
        return new RoomReservationTime(this.roomRepository.findById(id).get().getName(), new ArrayList<>());
    }

    @PatchMapping("/room")
    public Room patchRoom(@RequestBody Room room){
        this.roomRepository.save(room);
        return room;
    }


}
