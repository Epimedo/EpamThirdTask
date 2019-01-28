package by.epam.task3.halavin.controller.command;

import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.service.ServiceListDispatcher;
import by.epam.task3.halavin.service.exception.ServiceException;
import by.epam.task3.halavin.service.factory.DispatcherFactory;
import by.epam.task3.halavin.service.source.FileNames;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SaxListCommand implements Commmand {

    @Override
    public void execute(String category, HttpServletRequest request, HttpServletResponse response)
            throws ServiceException {
        DispatcherFactory dispatcher = DispatcherFactory.getInstance();
        dispatcher.setSource(FileNames.valueOf(category.trim().toUpperCase()));

        List<Food> list = null;
        ServiceListDispatcher serviceListDispatcher = DispatcherFactory.getInstance().createSaxDispatcher();
        HttpSession session = request.getSession(true);
        session.setAttribute(request.getParameter("category"), serviceListDispatcher);

        try {
            list = serviceListDispatcher.getNextFoodListItems();
        } catch (ServiceException e) {
            throw e;
        }

        request.setAttribute("category", request.getParameter("category"));
        request.setAttribute("Foods", list);

    }
}
