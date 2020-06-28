package com.unittesting.unittesting.service;

import com.unittesting.unittesting.model.Item;
import com.unittesting.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retreiveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retreiveAllItems() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQty());
        }
        return items;
    }
}
