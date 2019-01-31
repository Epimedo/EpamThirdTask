package by.epam.task3.halavin.util;

public enum Resources {
    COMMAND("command"),CATEGORY("category"),SAX_MENU("WEB-INF/view/saxMenu.jsp")
    ,STAX_MENU("WEB-INF/view/staxMenu.jsp"),DOM_MENU("WEB-INF/view/domMenu.jsp");

    private String str;

    private Resources(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
