package com.unittesting.unittesting.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeServiceMockTest {

    @InjectMocks
    SomeServiceImpl someService;

    @Mock
    SomeDataService mockDataService;

    @Test
    public void calculateSumUsingDataService_basic_test() {
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, someService.calculateSumUsingDateService());
    }

    @Test
    public void calculateSumUsingDataService_empty_test() {
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, someService.calculateSumUsingDateService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue_test() {
        when(mockDataService.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5, someService.calculateSumUsingDateService());
    }
}
