package com.unittesting.unittesting.integrationTest;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ItemControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void contextLoads_test() throws JSONException {
        String response = this.testRestTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals("[{id:10001}, {id:10002}, {id:10003}]", response, false);
    }
}
