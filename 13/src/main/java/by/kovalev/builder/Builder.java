package by.kovalev.builder;

import by.kovalev.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws
            RepositoryException, RepositoryException;
}
