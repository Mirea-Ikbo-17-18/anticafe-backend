package com.ikbo.anticafe.Controllers;

import com.ikbo.anticafe.Models.Reservation;
import com.ikbo.anticafe.Models.Room;
import com.ikbo.anticafe.Repositorys.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @FunctionalInterface
    private interface View {
        @Data
        @AllArgsConstructor
        class ViewRoom{
            private Long id;
            private String name;
            private String description;
            private Integer cost;
            private Date start;
            private Date finish;
            private Long room_reservation_id;
        }
        ViewRoom transformRoom(Room room);
    }

    @GetMapping("/rooms")
    public List<View.ViewRoom> getRooms(){
        Collection<Room> roomCollection = (Collection<Room>) roomRepository.findAll();
        View view = (room) -> new View.ViewRoom(room.getId(), room.getName(), room.getDescription(), room.getCost(),
                                                room.getStart(), room.getFinish(), room.getRoom_reservation_id().getId());
        return roomCollection.stream().map(view::transformRoom).collect(Collectors.toList());
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
