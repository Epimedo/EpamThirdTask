package by.epam.task3.halavin.entity.builder;

import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.entity.creator.FoodCreator;

public class FoodBuilder {
    private Food food;

    public FoodBuilder(){
        food = FoodCreator.getInstance().create();
    }

    public Food getFood() {
        return food;
    }

    public FoodBuilder setId(int id){
        food.setId(id);
        return this;
    }

    public FoodBuilder setName(String name){
        food.setName(name);
        return this;
    }

    public FoodBuilder setPortion(String portion){
        food.setPortion(portion);
        return this;
    }

    public FoodBuilder setPrice(double price){
        food.setPrice(price);
        return this;
    }

    public FoodBuilder setImagine(String img){
        food.setImagine(img);
        return this;
    }

    public FoodBuilder addIngredient(String ingr){
        food.addIngredient(ingr);
        return this;
    }

    public FoodBuilder addChoosingIngr(String name,double price){
        food.addChoosingIngr(name,price);
        return this;
    }

    public FoodBuilder addAdditionalIngr(String name,double price){
        food.addAdditionalIngr(name,price);
        return this;
    }
}
