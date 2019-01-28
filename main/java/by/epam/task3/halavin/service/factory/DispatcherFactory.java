package by.epam.task3.halavin.service.factory;

import by.epam.task3.halavin.dao.repository.FoodRepository;
import by.epam.task3.halavin.service.ServiceListDispatcher;
import by.epam.task3.halavin.service.impl.ServiceDomListDispatcher;
import by.epam.task3.halavin.service.impl.ServiceSaxListDispatcher;
import by.epam.task3.halavin.service.impl.ServiceStaxListDispatcher;
import by.epam.task3.halavin.service.source.FileNames;

import java.util.HashMap;
import java.util.Map;

public class DispatcherFactory {
    private static DispatcherFactory instance = new DispatcherFactory();
    private static Map<FileNames, FoodRepository> saxMap = new HashMap<>();
    private static Map<FileNames, FoodRepository> staxMap = new HashMap<>();
    private static Map<FileNames, FoodRepository> domMap = new HashMap<>();

    private FileNames fileName;


    static {
        saxMap.put(FileNames.COLDSNACK,FoodRepository.SAX_COLDSNACK_REPOSITORY);
        saxMap.put(FileNames.WARMSNACK,FoodRepository.SAX_WARMSNACK_REPOSITORY);
        saxMap.put(FileNames.BREAKFAST,FoodRepository.SAX_BREAKFAST_REPOSITORY);
    }

    static {
        staxMap.put(FileNames.COLDSNACK,FoodRepository.STAX_COLDSNACK_REPOSITORY);
        staxMap.put(FileNames.WARMSNACK,FoodRepository.STAX_WARMSNACK_REPOSITORY);
        staxMap.put(FileNames.BREAKFAST,FoodRepository.STAX_BREAKFAST_REPOSITORY);
    }

    static {
        domMap.put(FileNames.COLDSNACK,FoodRepository.DOM_COLDSNACK_REPOSITORY);
        domMap.put(FileNames.WARMSNACK,FoodRepository.DOM_WARMSNACK_REPOSITORY);
        domMap.put(FileNames.BREAKFAST,FoodRepository.DOM_BREAKFAST_REPOSITORY);
    }

    public static DispatcherFactory getInstance(){
        return instance;
    }

    private DispatcherFactory(){
        super();
    }

    public void setSource(FileNames source){
        fileName = source;
    }

    public ServiceListDispatcher createSaxDispatcher(){
        ServiceSaxListDispatcher dispatcher = new ServiceSaxListDispatcher();
        dispatcher.setSource(fileName.getFileName());
        dispatcher.setFoodRepository(saxMap.get(fileName));
        return dispatcher;
    }

    public ServiceListDispatcher createStaxDispatcher(){
        ServiceStaxListDispatcher dispatcher = new ServiceStaxListDispatcher();
        dispatcher.setSource(fileName.getFileName());
        dispatcher.setFoodRepository(staxMap.get(fileName));
        return dispatcher;
    }

    public ServiceListDispatcher createDomDispatcher(){
        ServiceDomListDispatcher dispatcher = new ServiceDomListDispatcher();
        dispatcher.setSource(fileName.getFileName());
        dispatcher.setFoodRepository(domMap.get(fileName));
        return dispatcher;
    }

}
