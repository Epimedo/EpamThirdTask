package by.epam.task3.halavin.controller;

import by.epam.task3.halavin.controller.command.CommandNames;
import by.epam.task3.halavin.controller.command.CommandProvider;
import by.epam.task3.halavin.entity.Food;
import by.epam.task3.halavin.util.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StaxServlet extends HttpServlet {
    public static final Logger log = LogManager.getLogger(StaxServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> list = null;
        CommandProvider.getInstance().execute(CommandNames.valueOf(req.getParameter(Resources.COMMAND
                .getStr())) + " " + req.getParameter(Resources.CATEGORY.getStr()),req,resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Resources.STAX_MENU.getStr());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandProvider.getInstance().execute(CommandNames.valueOf(req.getParameter(Resources.COMMAND
                .getStr())) + " " + req.getParameter(Resources.CATEGORY.getStr()),req,resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Resources.STAX_MENU.getStr());
        requestDispatcher.forward(req, resp);
    }
}
