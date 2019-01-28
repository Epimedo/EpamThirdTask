package by.epam.task3.halavin.controller.command;

import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.service.ServiceListDispatcher;
import by.epam.task3.halavin.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChangeLocaleCommand implements Commmand {

    @Override
    public void execute(String str, HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<Food> list = null;

        HttpSession session = request.getSession();
        ServiceListDispatcher serviceListDispatcher = (ServiceListDispatcher)
                session.getAttribute(request.getParameter("category"));
        try {
            list = serviceListDispatcher.getCurrentFoodListItems();
        } catch (ServiceException e) {
            throw e;
        }

        session.setAttribute("local",request.getParameter("local"));
        request.setAttribute("local",request.getParameter("local"));
        request.setAttribute("category", request.getParameter("category"));
        request.setAttribute("Foods", list);
    }
}
