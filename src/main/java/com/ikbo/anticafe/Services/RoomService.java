package com.ikbo.anticafe.Services;

import com.ikbo.anticafe.Repositorys.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String getRoom(Long id) {

        return this.roomRepository.findById(id).stream().findFirst().get().toString();
    }
}
