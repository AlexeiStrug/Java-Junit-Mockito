package com.unittesting.unittesting.service;

import com.unittesting.unittesting.model.Item;
import com.unittesting.unittesting.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void retreiveAllItems_basic_test() {
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(new Item(2, "Item 2", 10, 10),
                new Item(3, "Item 3", 5, 20))
        );

        List<Item> items = itemService.retreiveAllItems();

        assertEquals(100, items.get(0).getValue());
        assertEquals(100, items.get(1).getValue());
    }
}
