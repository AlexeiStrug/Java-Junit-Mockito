package com.unittesting.unittesting.service;

public class SomeServiceImpl {

    private SomeDataService dataService;

    public void setDataService(SomeDataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value: data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDateService() {
        int[] data = dataService.retrieveAllData();
        int sum = 0;
        for (int value: data) {
            sum += value;
        }
        return sum;
    }
}
