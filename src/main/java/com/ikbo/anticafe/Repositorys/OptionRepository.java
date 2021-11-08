package com.ikbo.anticafe.Repositorys;

import com.ikbo.anticafe.Models.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {

}
