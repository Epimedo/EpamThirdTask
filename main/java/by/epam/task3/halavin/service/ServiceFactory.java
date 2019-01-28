package by.epam.task3.halavin.service;

import by.epam.task3.halavin.entity.builder.FoodBuilder;
import by.epam.task3.halavin.service.impl.ServiceFoodParserImpl;

public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    private ServiceFoodParser serviceFoodParser = new ServiceFoodParserImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ServiceFoodParser getServiceFoodParser() {
        return serviceFoodParser;
    }

    public FoodBuilder createFoodBuilder(){
        return new FoodBuilder();
    }
}
