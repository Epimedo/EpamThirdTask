package by.epam.task3.halavin.service;

import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.service.exception.ServiceException;

import java.util.List;

public interface ServiceFoodParser {

    List<Food> getListBySax(String source) throws ServiceException;

    List<Food> getListByStax(String source) throws ServiceException;

    List<Food> getListByDom(String source) throws ServiceException;
}
