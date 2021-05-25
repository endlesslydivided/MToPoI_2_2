package by.kovalev.repository;

import by.kovalev.builder.UserBuilder;
import by.kovalev.dbconstants.UserTableConstants;
import by.kovalev.exception.RepositoryException;
import by.kovalev.model.User;
import by.kovalev.paramspecification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class UserRepository extends AbstractRepository <User>{
    public UserRepository(Connection connection){
        super(connection);
    }
    @Override
    protected String getTableName() {
        return SQLHelper.USER_TABLE;
    }
    @Override
    public List<User> query(String sqlString, Parameter paramater) throws RepositoryException {
        List<User> users = executeQuery(sqlString, (Stream.Builder<User>) new UserBuilder(), paramater.getParameters());
        return users;
    }
    @Override
    public Optional<User> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException {
        List<User> user = query(sqlString, parameter);
        return user.size() == 1 ?
                Optional.of(user.get(0)) :
                Optional.empty();
    }
    public Map<String,Object> getFields(User user) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(UserTableConstants.LOGIN.getFieldName(), user.getLogin());
        fields.put(UserTableConstants.PASSWORD.getFieldName(), user.getPassw());
        return fields;
    }
}