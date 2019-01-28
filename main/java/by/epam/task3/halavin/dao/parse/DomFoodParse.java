package by.epam.task3.halavin.dao.parse;

import by.epam.task3.halavin.dao.exception.DAOEception;
import by.epam.task3.halavin.dao.tags.Prefixes;
import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.entity.builder.FoodBuilder;
import by.epam.task3.halavin.service.ServiceFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DomFoodParse implements Parserable<Food> {
    private static final double DEFAULT_PRICE = 0.0;

    private final Pattern pat = Pattern.compile("^\\s*$");
    private List<Food> list = new ArrayList<Food>();
    private FoodBuilder foodBuilder = null;


    public List<Food> parse(String string) throws DAOEception {
        File inputFile = new File(string);
        Document doc;
        String prefix = Prefixes.FOOD.getName() + ":";

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOEception(e);
        }

        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName(Prefixes.ROOT.getName() + ":food");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            initFood(element, prefix);
            foodBuilder.setImagine(getSingleChild(element, prefix + "imagine").getTextContent());
            getIngredients(element, prefix);
            getAdditionalIngredints(element, prefix);
            getChoosingIngredints(element, prefix);
            list.add(foodBuilder.getFood());
        }
        return list;
    }

    private void initFood(Element element, String prefix) {
        foodBuilder = ServiceFactory.getInstance().createFoodBuilder();
        foodBuilder.setId(Integer.parseInt(element.getAttribute(prefix + "foodId")))
                .setName(element.getAttribute(prefix + "name"))
                .setPortion(element.getAttribute(prefix + "portion"));
        if (!element.getAttribute(prefix + "price").isEmpty()) {
            foodBuilder.setPrice(Double.parseDouble(element.getAttribute(prefix + "price")));
        }
    }

    private void getIngredients(Element element, String prefix) {
        NodeList nodeList = element.getElementsByTagName(prefix + "ingredient");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element1 = (Element) nodeList.item(i);
            foodBuilder.addIngredient(element1.getTextContent().trim());
        }
    }

    private void getAdditionalIngredints(Element element, String prefix) {
        NodeList nodeList = element.getElementsByTagName(prefix + "additionalIngredient");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element1 = (Element) nodeList.item(i);
            String name = getSingleChild(element1, prefix + "additionalName").getTextContent().trim();
            String value = getSingleChild(element1,
                    prefix + "additionalPrice").getTextContent().trim();
            if (value.isEmpty()) {
                foodBuilder.addAdditionalIngr(name, DEFAULT_PRICE);
            } else {
                foodBuilder.addAdditionalIngr(name, Double.parseDouble(value));
            }

        }
    }

    private void getChoosingIngredints(Element element, String prefix) {
        NodeList list = element.getElementsByTagName(prefix + "ingredientsForChoose");

        for (int i = 0; i < list.getLength(); i++) {
            Element root = (Element) list.item(i);
            NodeList nodeListIngr = root.getElementsByTagName(prefix + "ingredientForChoose");

            for (int j = 0; j < nodeListIngr.getLength(); j++) {
                Element elem = (Element) nodeListIngr.item(j);
                String name = getSingleChild(elem, prefix + "ingrName").getTextContent().trim();
                String value = getSingleChild(elem, prefix + "priceWithIngr").getTextContent().trim();

                if (value.isEmpty()) {
                    foodBuilder.addChoosingIngr(name, DEFAULT_PRICE);
                } else {
                    foodBuilder.addChoosingIngr(name, Double.parseDouble(value));
                }
            }
        }
    }

    private Element getSingleChild(Element element, String tag) {
        NodeList nodeList = element.getElementsByTagName(tag);
        Element element1 = (Element) nodeList.item(0);
        return element1;
    }
}
