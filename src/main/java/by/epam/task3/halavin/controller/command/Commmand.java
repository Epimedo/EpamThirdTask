package by.epam.task3.halavin.controller.command;

import by.epam.task3.halavin.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Commmand {

    public void execute(String str, HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
