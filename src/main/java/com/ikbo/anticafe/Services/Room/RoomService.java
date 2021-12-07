package com.ikbo.anticafe.Services.Room;

import com.ikbo.anticafe.Models.Reservation;
import com.ikbo.anticafe.Models.Room;
import com.ikbo.anticafe.Repositorys.ReservationRepository;
import com.ikbo.anticafe.Repositorys.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public String getRoom(Long id) {
        return this.roomRepository.findById(id).stream().findFirst().get().toString();
    }

    public List<View.ViewRoom> getElements(){
        Collection<Room> roomCollection = (Collection<Room>) roomRepository.findAll();
        View view = (room) -> new View.ViewRoom(room.getId(), room.getName(), room.getDescription(),
                room.getCost(), room.getStart(), room.getFinish(),
                room.getReservation().stream().map(Reservation::getId).collect(Collectors.toList()));
        return roomCollection.stream().map(view::transformRoom).collect(Collectors.toList());
    }

    public List<Integer> getTimes(Integer idRoom){
        return reservationRepository.findByRm(roomRepository.findById(idRoom.longValue()).get())
                                    .stream().map(reservation -> reservation.getStart().getHours() + 1)
                                    .collect(Collectors.toList());
    }


}
