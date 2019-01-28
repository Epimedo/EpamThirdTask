package by.epam.task3.halavin.service;

import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.service.exception.ServiceException;

import java.util.List;

public interface ServiceListDispatcher {
    int NUMBER_PLUS = 5;

    void setSource(String str);

    List<Food> getNextFoodListItems() throws ServiceException;

    List<Food> getCurrentFoodListItems() throws ServiceException;
}
