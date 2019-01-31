package com.molveno.molveno.restaurant.menu;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish,Long> {
    List<Dish> findAll();



}
