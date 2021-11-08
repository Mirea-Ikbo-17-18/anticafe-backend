package com.ikbo.anticafe.Repositorys;

import com.ikbo.anticafe.Models.KitOptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitOptionRepository extends CrudRepository<KitOptions, Long> {
    
}
