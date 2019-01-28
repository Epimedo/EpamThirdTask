package by.epam.task3.halavin.dao.parse;

import by.epam.task3.halavin.dao.exception.DAOEception;

import java.util.List;

public interface Parserable<E> {

    List<E> parse(String source) throws DAOEception;
}
