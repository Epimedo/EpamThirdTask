package by.epam.task3.halavin.dao.parse;

import by.epam.task3.halavin.dao.tags.FoodTags;
import by.epam.task3.halavin.dao.tags.HandlerFoodTags;
import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.entity.builder.FoodBuilder;
import by.epam.task3.halavin.service.ServiceFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SaxFoodHandler extends DefaultHandler {
    private final Pattern pat = Pattern.compile("^\\s*$");
    private String name;
    private String tag = "";
    private String prefix;
    private StringBuilder str;
    private double value;
    private List<Food> foods = new ArrayList<Food>();
    private FoodBuilder foodBuilder;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        this.prefix = prefix + ":";
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        FoodTags tagName = FoodTags.valueOf(localName.toUpperCase());
        tag = localName.toUpperCase();

        switch (tagName) {
            case FOOD:
                initFood(attributes);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        FoodTags tagName = FoodTags.valueOf(localName.toUpperCase());

        switch (tagName) {
            case FOOD:
                foods.add(foodBuilder.getFood());
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

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        str = new StringBuilder();
        str.append(ch, start, length);
        if (!pat.matcher(str.toString()).matches()) {
            FoodTags tagName = FoodTags.valueOf(tag);
            switch (tagName) {
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

    public List<Food> getFoods() {
        return foods;
    }

    public void initFood(Attributes attributes) {
        foodBuilder = ServiceFactory.getInstance().createFoodBuilder();

        foodBuilder.setId(Integer.parseInt(attributes.getValue(prefix + HandlerFoodTags.ATTR_ID.getStr())))
                .setName(attributes.getValue(prefix + HandlerFoodTags.ATTR_NAME.getStr()))
                .setPortion(attributes.getValue(prefix + HandlerFoodTags.ATTR_PORTION.getStr()));
        if (!attributes.getValue(prefix + HandlerFoodTags.ATTR_PRICE.getStr()).isEmpty()) {
            foodBuilder.setPrice(Double.parseDouble(attributes.getValue(prefix + HandlerFoodTags.ATTR_PRICE
                    .getStr())));
        }
    }
}

