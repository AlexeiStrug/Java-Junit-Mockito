package com.unittesting.unittesting.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceCStub implements SomeDataService {
    private int[] values;

    public SomeDataServiceCStub(int[] values) {
        this.values = values;
    }

    @Override
    public int[] retrieveAllData() {
        return values;
    }
}

public class SomeServiceStubTest {

    @Test
    public void calculateSum_basic_test() {
        SomeServiceImpl someService = new SomeServiceImpl();
        int actualResult = someService.calculateSum(new int[]{1, 2, 3});
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSum_empty_test() {
        SomeServiceImpl someService = new SomeServiceImpl();
        int actualResult = someService.calculateSum(new int[]{});
        int expectResult = 0;

        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue_test() {
        SomeServiceImpl someService = new SomeServiceImpl();
        int actualResult = someService.calculateSum(new int[]{5});
        int expectResult = 5;

        assertEquals(expectResult, actualResult);
    }


    @Test
    public void calculateSumUsingDataService_basic_test() {
        SomeServiceImpl someService = new SomeServiceImpl();
        someService.setDataService(new SomeDataServiceCStub(new int[] {1,2,3}));
        int actualResult = someService.calculateSumUsingDateService();
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty_test() {
        SomeServiceImpl someService = new SomeServiceImpl();
        someService.setDataService(new SomeDataServiceCStub(new int[] {}));
        int actualResult = someService.calculateSumUsingDateService();
        int expectResult = 0;

        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue_test() {
        SomeServiceImpl someService = new SomeServiceImpl();
        someService.setDataService(new SomeDataServiceCStub(new int[] {5}));
        int actualResult = someService.calculateSumUsingDateService();
        int expectResult = 5;

        assertEquals(expectResult, actualResult);
    }
}
