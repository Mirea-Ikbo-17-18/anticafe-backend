package com.ikbo.anticafe.Repositorys;

import com.ikbo.anticafe.Model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
