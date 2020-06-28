package com.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UnitTestingApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void learning_test() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        assertThat(numbers)
                .hasSize(3)
                .contains(15, 45)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100);

//        assertThat(numbers, hasSize(3));
//		assertThat(numbers, hasItems(15,45));
//		assertThat(numbers, everyItem(greaterThan(10)));
//		assertThat(numbers, everyItem(lessThan(100)));
//		assertThat("", is(emptyString()));
    }

}
