package by.epam.task3.halavin.dao.repository;

import by.epam.task3.halavin.entity.Food;

import java.util.List;

public enum FoodRepository {
    SAX_COLDSNACK_REPOSITORY,SAX_WARMSNACK_REPOSITORY,SAX_BREAKFAST_REPOSITORY,
    STAX_COLDSNACK_REPOSITORY,STAX_WARMSNACK_REPOSITORY,STAX_BREAKFAST_REPOSITORY,
    DOM_COLDSNACK_REPOSITORY,DOM_WARMSNACK_REPOSITORY,DOM_BREAKFAST_REPOSITORY;

    private List<Food> list;

    public List<Food> getList() {
        return list;
    }

    public void setList(List<Food> list) {
        this.list = list;
    }

    public void cleanList() {
        list = null;
    }
}
