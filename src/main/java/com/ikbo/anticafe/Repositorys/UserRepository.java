package com.ikbo.anticafe.Repositorys;

import com.ikbo.anticafe.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
