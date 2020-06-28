package com.unittesting.unittesting.controller;

import com.unittesting.unittesting.model.Item;
import com.unittesting.unittesting.service.ItemService;
import com.unittesting.unittesting.service.ItemServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void basic_test() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"))
                .andReturn();

        assertEquals("Hello World!", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getDummyItem_test() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"qty\":100}"))
                .andReturn();

        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"qty\":100}";
        JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), true);
    }

    @Test
    public void getItemFromService_test() throws Exception {
        when(itemService.retreiveHardcodedItem()).thenReturn(new Item(2, "Item 2", 10, 10));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"qty\":10}"))
                .andReturn();

        String expectedResponse = "{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"qty\":10}";
        JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), true);
    }


    @Test
    public void getAllItems_oneItem_test() throws Exception {
        when(itemService.retreiveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item 2", 10, 10))
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"qty\":10}]"))
                .andReturn();

        String expectedResponse = "[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"qty\":10}]";
        JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), false);
    }

    @Test
    public void getAllItems_twoItems_test() throws Exception {
        when(itemService.retreiveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item 2", 10, 10),
                        new Item(3, "Item 3", 5, 20))
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"qty\":10}, {\"id\":3,\"name\":\"Item 3\",\"price\":5,\"qty\":20}]"))
                .andReturn();

        String expectedResponse = "[{\"id\":2,\"name\":\"Item 2\",\"price\":10,\"qty\":10}, {\"id\":3,\"name\":\"Item 3\",\"price\":5,\"qty\":20}]";
        JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), false);
    }


}
