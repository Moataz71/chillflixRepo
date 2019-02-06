package com.molveno.molveno.restaurant.table;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
public interface TableRepository extends CrudRepository<Tablee, Long> {
    List<Tablee> findAll();
    Tablee findById(long id);


}
