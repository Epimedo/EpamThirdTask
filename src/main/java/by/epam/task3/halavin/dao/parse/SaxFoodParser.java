package by.epam.task3.halavin.dao.parse;

import by.epam.task3.halavin.dao.exception.DAOEception;
import by.epam.task3.halavin.entity.Food;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxFoodParser implements Parserable<Food> {

    @Override
    public List<Food> parse(String source) throws DAOEception {
        InputSource sourceInput = new InputSource(source);
        List<Food> foodList;
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            SaxFoodHandler handler = new SaxFoodHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(sourceInput);
            foodList = handler.getFoods();

        } catch (SAXException | IOException e) {
            throw new DAOEception(e);
        }
        return foodList;
    }
}
