package com.example.septass1.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface Dao<Item> {

    Optional<Item> get(int id);

    List<Item> getAll();

    void save(Item item);

    void update(Item item, int id);

    void delete(int id);
}
