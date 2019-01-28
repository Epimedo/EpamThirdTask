package by.epam.task3.halavin.entity.creator;

import by.epam.task3.halavin.entity.Food;

public class FoodCreator implements Creator {
    private static FoodCreator instance = new FoodCreator();

    private FoodCreator(){
        super();
    }

    public static FoodCreator getInstance(){
        return instance;
    }

    @Override
    public Food create() {
        return new Food();
    }
}
