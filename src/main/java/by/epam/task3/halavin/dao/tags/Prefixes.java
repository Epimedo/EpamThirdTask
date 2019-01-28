package by.epam.task3.halavin.dao.tags;

public enum Prefixes {
    FOOD("fd"), ROOT("cat");

    private String str;

    Prefixes(String str) {
        this.str = str;
    }

    public String getName() {
        return str;
    }

}
