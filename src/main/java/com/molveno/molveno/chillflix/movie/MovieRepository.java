package com.molveno.molveno.chillflix.movie;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
public interface MovieRepository  extends CrudRepository<Movie, Long>{
    List<Movie> findAll();
    Movie findById(long id);

}
