package com.unittesting.unittesting.repository;

import com.unittesting.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;


    @Test
    public void findAll_test() {
        List<Item> items = itemRepository.findAll();

        assertEquals(3, items.size());
    }

}
