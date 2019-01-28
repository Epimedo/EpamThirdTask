package by.epam.task3.halavin.controller.command;

import by.epam.task3.halavin.controller.StaxServlet;
import by.epam.task3.halavin.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    public static final Logger log = LogManager.getLogger(StaxServlet.class);
    private static CommandProvider instance = new CommandProvider();
    private static Map<CommandNames, Commmand> map = new HashMap<>();

    static {
        map.put(CommandNames.SAXLIST, new SaxListCommand());
        map.put(CommandNames.STAXLIST, new StaxListCommand());
        map.put(CommandNames.DOMLIST, new DomListCommand());
        map.put(CommandNames.NEXTSAXLIST, new NextSaxListCommand());
        map.put(CommandNames.NEXTSTAXLIST, new NextStaxListCommmand());
        map.put(CommandNames.NEXTDOMLIST, new NextDomListCommand());
        map.put(CommandNames.CHANGELOCALE, new ChangeLocaleCommand());
    }

    private CommandProvider() {
        super();
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public void execute(String requestString, HttpServletRequest request, HttpServletResponse response) {
        String[] input = requestString.split("\\s");
        Commmand commmand = map.get(CommandNames.valueOf(input[0]));
        try {
            commmand.execute(input[1], request, response);
        } catch (ServiceException e) {
            log.error(e);
        }
    }
}
