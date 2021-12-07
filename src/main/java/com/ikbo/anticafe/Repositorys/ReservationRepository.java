package com.ikbo.anticafe.Repositorys;

import com.ikbo.anticafe.Models.Reservation;
import com.ikbo.anticafe.Models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByRm(Room room);
}
