package by.epam.task3.halavin.service.source;

public enum FileNames {
    COLDSNACK("D:\\Java\\IntelliJ IDEA Workplace\\EpamThirdTask\\resource\\coldSnacks.xml"),
    WARMSNACK("D:\\Java\\IntelliJ IDEA Workplace\\EpamThirdTask\\resource\\warmSnacks.xml"),
    BREAKFAST("D:\\Java\\IntelliJ IDEA Workplace\\EpamThirdTask\\resource\\breakfasts.xml");

    private String fileName;

    private FileNames(String str){
        fileName=str;
    }

    public String getFileName() {
        return fileName;
    }
}
