package com.example.septass1.controller;

import java.util.List;
import java.util.Optional;

import com.example.septass1.dao.Dao;
import com.example.septass1.dao.ItemDao;
import com.example.septass1.exception.ItemNotFound;
import com.example.septass1.exception.ItemNotFoundException;
import com.example.septass1.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.Name;


@RestController

class controller {


    @Autowired
    private ItemDao repository;



    controller(ItemDao repository) {
        this.repository = repository;
    }


    // Aggregate root

    // tag::get-aggregate-root[]
    @GetMapping("items")
    List<ItemDao> all() {
        return repository.getAll();
    }
////    // end::get-aggregate-root[]
////
    @PostMapping("/items")
    void newItem(@RequestBody Item newItem) {
        repository.save(newItem);
    }

//    // Single item
//
    @GetMapping("/items/{id}")
    Optional one(@PathVariable int id) {

         return repository.get(id);

    }
//
    @PutMapping("/items/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable int id) {
        repository.update(newItem, id);
//                .map(Item -> {
//                    Item.setId(newItem.getId());
//                    Item.setName(newItem.getName());
//                    Item.setDesc(newItem.getDesc());
//                    Item.setPrice(newItem.getPrice());
//                    return repository.save(newItem);
//                })
//                .orElseGet(() -> {
//                    newItem.setId(id);
//                    return repository.save(newItem);
//                });
        return newItem;
 }
//
    @DeleteMapping("/items/{id}")
    void deleteItem(@PathVariable int id) {
        repository.delete(id);
    }
//}
}

