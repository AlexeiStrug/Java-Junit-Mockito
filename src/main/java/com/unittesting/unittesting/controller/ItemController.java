package com.unittesting.unittesting.controller;

import com.unittesting.unittesting.model.Item;
import com.unittesting.unittesting.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/hello-world")
    public String getHelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/dummy-item")
    public Item getDummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-service")
    public Item getItemFromService() {
        return itemService.retreiveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> getAllItems() {
        return itemService.retreiveAllItems();
    }
}
