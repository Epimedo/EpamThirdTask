package by.epam.task3.halavin.dao.tags;

public enum HandlerFoodTags {
    ATTR_ID("foodId"), ATTR_NAME("name"), ATTR_PORTION("portion"), ATTR_PRICE("price"),FOOD("food"),
    IMAGINE("imagine"),INGREDIENT("ingredient"),ADD_INGREDIENT("additionalIngredient"),
    ADD_NAME("additionalName"),ADD_PRICE("additionalPrice"),INGRS_FOR_CHOOSE("ingredientsForChoose"),
    INGR_FOR_CHOOSE("ingredientForChoose"),INGR_NAME("ingrName"),INGR_PRICE("priceWithIngr");

    private String str;

    HandlerFoodTags(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
