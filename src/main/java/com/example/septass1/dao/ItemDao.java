package com.example.septass1.dao;

import com.example.septass1.model.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class ItemDao implements Dao<Item> {

    private List<Item > ItemList;

    public ItemDao()
    {
        ItemList = new LinkedList<>();
        ItemList.add(new Item("1", "name1", "desc1", 1.0));
        ItemList.add(new Item("2", "name2", "desc2", 2.0));
        ItemList.add(new Item("3", "name3", "desc3", 3.0));
        ItemList.add(new Item("4", "name4", "desc4", 4.0));


    }
    @Override
    public Optional get(int id) {
        return Optional.ofNullable(ItemList.get((int)id - 1));
    }

    @Override
    public List getAll() {
        return ItemList;
    }

    @Override
    public void save(Item item) {
        ItemList.add(item);
    }


    @Override
    public void update(Item item, int id) {
        ItemList.set(id, item);
    }

    @Override
    public void delete(int id) {
        ItemList.remove(id);
    }
}
