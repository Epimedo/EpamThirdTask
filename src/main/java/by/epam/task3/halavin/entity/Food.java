package by.epam.task3.halavin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Food implements Serializable {
    private int id;
    private String name;
    private String portion;
    private double price;
    private String imagine;

    private List<String> mainIngredients = new ArrayList<String>();
    private List<String> addIngrName = new ArrayList<>();
    private List<Double> addIngrValue = new ArrayList<>();
    private List<String> choosingIngrName;
    private List<Double> choosingIngrValue;

    public Food() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    public List<String> getAddIngrName() {
        return addIngrName;
    }

    public void setAddIngrName(List<String> addIngrName) {
        this.addIngrName = addIngrName;
    }

    public List<Double> getAddIngrValue() {
        return addIngrValue;
    }

    public void setAddIngrValue(List<Double> addIngrValue) {
        this.addIngrValue = addIngrValue;
    }

    public List<String> getChoosingIngrName() {
        return choosingIngrName;
    }

    public void setChoosingIngrName(List<String> choosingIngrName) {
        this.choosingIngrName = choosingIngrName;
    }

    public List<Double> getChoosingIngrValue() {
        return choosingIngrValue;
    }

    public void setChoosingIngrValue(List<Double> choosingIngrValue) {
        this.choosingIngrValue = choosingIngrValue;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(List<String> mainIngredients) {
        this.mainIngredients = mainIngredients;
    }


    public void addAdditionalIngr(String name, double price) {
        addIngrName.add(name);
        addIngrValue.add(price);
    }

    public void addChoosingIngr(String name, double price) {

        if (choosingIngrName == null) {
            choosingIngrName = new ArrayList<>();
            choosingIngrValue = new ArrayList<>();
        }
        choosingIngrName.add(name);
        choosingIngrValue.add(price);
    }

    public void addIngredient(String name) {
        mainIngredients.add(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id &&
                Double.compare(food.price, price) == 0 &&
                Objects.equals(name, food.name) &&
                Objects.equals(portion, food.portion) &&
                Objects.equals(imagine, food.imagine) &&
                mainIngredients.equals(food.mainIngredients) &&
                addIngrName.equals(food.addIngrName) &&
                addIngrValue.equals(food.addIngrValue) &&
                choosingIngrName.equals(food.choosingIngrName) &&
                choosingIngrValue.equals(food.choosingIngrValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portion, price, imagine, mainIngredients, addIngrName
                , addIngrValue, choosingIngrName, choosingIngrValue);
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", portion='" + portion + '\'' +
                ", price=" + price +
                ", imagine='" + imagine + '\'' +
                ", mainIngredients=" + mainIngredients +
                ", addIngrName=" + addIngrName +
                ", addIngrValue=" + addIngrValue +
                ", choosingIngrName=" + choosingIngrName +
                ", choosingIngrValue=" + choosingIngrValue +
                '}';
    }
}
