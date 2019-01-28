package by.epam.task3.halavin.dao;

import by.epam.task3.halavin.dao.parse.SaxFoodHandler;
import org.xml.sax.helpers.DefaultHandler;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();
    private DefaultHandler defaultHandler = new SaxFoodHandler();

    public static DAOFactory getInstance(){
        return  instance;
    }

    public DefaultHandler getDefaultHandler(){
        return defaultHandler;
    }

}
