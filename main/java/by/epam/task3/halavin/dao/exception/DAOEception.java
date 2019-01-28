package by.epam.task3.halavin.dao.exception;

public class DAOEception extends Exception {

    public DAOEception() {
        super();
    }

    public DAOEception(String message) {
        super(message);
    }

    public DAOEception(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOEception(Throwable cause) {
        super(cause);
    }
}
