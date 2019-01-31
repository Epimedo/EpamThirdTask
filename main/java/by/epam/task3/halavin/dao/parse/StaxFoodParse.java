package by.epam.task3.halavin.dao.parse;

import by.epam.task3.halavin.dao.exception.DAOEception;
import by.epam.task3.halavin.dao.tags.FoodTags;
import by.epam.task3.halavin.dao.tags.HandlerFoodTags;
import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.entity.builder.FoodBuilder;
import by.epam.task3.halavin.service.ServiceFactory;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StaxFoodParse implements Parserable<Food> {
    private final Pattern pat = Pattern.compile("^\\s*$");
    private FoodBuilder foodBuilder;
    private StringBuilder str;
    private FoodTags foodTags = null;
    private String name = "";
    private double value = 0.0;
    private List<Food> list = new ArrayList<Food>();

    @Override
    public List<Food> parse(String source) throws DAOEception {
        try {
            int type;
            InputStream sr = new FileInputStream(source);
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(sr);

            while (xmlStreamReader.hasNext()) {
                type = xmlStreamReader.next();
                switch (type) {
                    case XMLStreamReader.START_ELEMENT:
                        startElement(xmlStreamReader);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        characterElement(xmlStreamReader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        endElement(xmlStreamReader);
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new DAOEception(e);
        }
        return list;
    }

    private void initFood(XMLStreamReader reader) {
        foodBuilder = ServiceFactory.getInstance().createFoodBuilder();
        foodBuilder.setId(Integer.parseInt(reader.getAttributeValue(null, HandlerFoodTags
                .ATTR_ID.getStr())))
                .setName(reader.getAttributeValue(null, HandlerFoodTags.ATTR_NAME.getStr()))
                .setPortion(reader.getAttributeValue(null, HandlerFoodTags.ATTR_PORTION.getStr()));
        if (!reader.getAttributeValue(null, HandlerFoodTags.ATTR_PRICE.getStr()).isEmpty()) {
            foodBuilder.setPrice(Double.parseDouble(reader.getAttributeValue(null, HandlerFoodTags
                    .ATTR_PRICE.getStr())));
        }
    }

    private void startElement(XMLStreamReader reader) {
        foodTags = FoodTags.valueOf(reader.getLocalName().toUpperCase());
        switch (foodTags) {
            case FOOD:
                initFood(reader);
                break;
        }
    }

    private void characterElement(XMLStreamReader reader) {
        str = new StringBuilder();
        str.append(reader.getText().trim());
        if (!pat.matcher(str.toString()).matches()) {
            switch (foodTags) {
                case INGRNAME:
                case IMAGINE:
                case ADDITIONALNAME:
                case INGREDIENT:
                    name = str.toString();
                    break;
                case ADDITIONALPRICE:
                case PRICEWITHINGR:
                    value = Double.parseDouble(str.toString());
                    break;
            }
        }
    }

    private void endElement(XMLStreamReader reader) {
        foodTags = FoodTags.valueOf(reader.getLocalName().toUpperCase());
        switch (foodTags) {
            case FOOD:
                list.add(foodBuilder.getFood());
                break;
            case IMAGINE:
                foodBuilder.setImagine(name);
                break;
            case INGREDIENT:
                foodBuilder.addIngredient(name);
                break;
            case INGREDIENTFORCHOOSE:
                foodBuilder.addChoosingIngr(name, value);
                break;
            case ADDITIONALINGREDIENT:
                foodBuilder.addAdditionalIngr(name, value);
                break;
        }
    }
}
