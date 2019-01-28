package by.epam.task3.halavin.service.impl;

import by.epam.task3.halavin.dao.exception.DAOEception;
import by.epam.task3.halavin.dao.parse.DomFoodParse;
import by.epam.task3.halavin.dao.parse.Parserable;
import by.epam.task3.halavin.dao.parse.SaxFoodParser;
import by.epam.task3.halavin.dao.parse.StaxFoodParse;
import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.service.ServiceFoodParser;
import by.epam.task3.halavin.service.exception.ServiceException;

import java.util.List;

public class ServiceFoodParserImpl implements ServiceFoodParser {

    @Override
    public List<Food> getListBySax(String source) throws ServiceException {
        List<Food> list;
        Parserable<Food> parser = new SaxFoodParser();

        try {
            list = parser.parse(source);
        } catch (DAOEception e) {
            throw new ServiceException(e);
        }

        return list;
    }

    @Override
    public List<Food> getListByStax(String source) throws ServiceException {
        List<Food> list;
        Parserable<Food> parser = new StaxFoodParse();

        try {
            list = parser.parse(source);
        } catch (DAOEception e) {
            throw new ServiceException(e);
        }

        return list;

    }

    @Override
    public List<Food> getListByDom(String source) throws ServiceException {
        List<Food> list;
        Parserable<Food> parser = new DomFoodParse();

        try {
            list = parser.parse(source);
        } catch (DAOEception e) {
            throw new ServiceException(e);
        }

        return list;
    }
}
