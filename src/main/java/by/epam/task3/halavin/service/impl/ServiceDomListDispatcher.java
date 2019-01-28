package by.epam.task3.halavin.service.impl;

import by.epam.task3.halavin.dao.repository.FoodRepository;
import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.service.ServiceFactory;
import by.epam.task3.halavin.service.ServiceFoodParser;
import by.epam.task3.halavin.service.ServiceListDispatcher;
import by.epam.task3.halavin.service.exception.ServiceException;

import java.util.List;

public class ServiceDomListDispatcher implements ServiceListDispatcher {
    private int currentPosition = 0;
    private FoodRepository foodRepository;
    private String source = "";

    public ServiceDomListDispatcher() {
        super();
    }

    public void setFoodRepository(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void setSource(String str) {
        source = str;
    }

    @Override
    public List<Food> getNextFoodListItems() throws ServiceException {
        List<Food> list;

        checkList();

        list = foodRepository.getList();
        if (currentPosition >= list.size()) {
            currentPosition = 0;
        }
        if (currentPosition + ServiceListDispatcher.NUMBER_PLUS > list.size()) {
            int num = currentPosition;
            currentPosition += ServiceListDispatcher.NUMBER_PLUS;

            return list.subList(num, list.size());
        }

        return foodRepository.getList().subList(currentPosition, currentPosition += ServiceListDispatcher.NUMBER_PLUS);
    }

    @Override
    public List<Food> getCurrentFoodListItems() throws ServiceException {
        int firstIndex = currentPosition - ServiceListDispatcher.NUMBER_PLUS;
        int secondIndex = currentPosition;
        List<Food> list;

        checkList();
        list = foodRepository.getList();

        if (currentPosition >= list.size()) {
            firstIndex = currentPosition - ServiceListDispatcher.NUMBER_PLUS;
            secondIndex = list.size();
        } else if (currentPosition - ServiceListDispatcher.NUMBER_PLUS < 0) {
            firstIndex = currentPosition;
            secondIndex = currentPosition + ServiceListDispatcher.NUMBER_PLUS;
        }

        return foodRepository.getList().subList(firstIndex, secondIndex);
    }

    private void checkList() throws ServiceException {
        List<Food> list;

        if (foodRepository.getList() == null) {
            ServiceFactory factory = ServiceFactory.getInstance();
            ServiceFoodParser parser = factory.getServiceFoodParser();

            try {
                list = parser.getListByDom(source);
                foodRepository.setList(list);
                currentPosition = 0;
            } catch (ServiceException e) {
                throw e;
            }
        }
    }
}
