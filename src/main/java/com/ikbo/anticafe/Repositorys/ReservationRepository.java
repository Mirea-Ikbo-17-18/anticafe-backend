package com.ikbo.anticafe.Repositorys;

import com.ikbo.anticafe.Models.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
