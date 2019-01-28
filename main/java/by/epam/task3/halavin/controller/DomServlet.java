package by.epam.task3.halavin.controller;

import by.epam.task3.halavin.controller.command.CommandNames;
import by.epam.task3.halavin.controller.command.CommandProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DomServlet extends HttpServlet {
    public static final Logger log = LogManager.getLogger(SaxServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandProvider.getInstance().execute(CommandNames.valueOf(req.getParameter("command"))
                + " " + req.getParameter("category"), req, resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/domMenu.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandProvider.getInstance().execute(CommandNames.valueOf(req.getParameter("command")) + " " +
                req.getParameter("category"), req, resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/domMenu.jsp");
        requestDispatcher.forward(req, resp);
    }
}
