package by.kovalev.repository;

import by.kovalev.builder.PersonBuilder;
import by.kovalev.dbconstants.PersonTableConstants;
import by.kovalev.exception.RepositoryException;
import by.kovalev.model.Person;
import by.kovalev.paramspecification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class PersonRepository extends AbstractRepository<Person> {
    public PersonRepository(Connection connection){
        super(connection);
    }
    @Override
    protected String getTableName() {
        return SQLHelper.PERSON_TABLE ;
    }
    @Override
    public List<Person> query(String sqlString, Parameter paramater) throws RepositoryException {
        List<Person> persons = executeQuery(sqlString, (Stream.Builder<Person>) new PersonBuilder(), paramater.getParameters());
        return persons;
    }
    @Override
    public Optional<Person> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException {
        List<Person> person = query(sqlString, parameter);
        return person.size() == 1 ?
                Optional.of(person.get(0)) :
                Optional.empty();
    }
    public Map<String,Object> getFields(Person person) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(PersonTableConstants.NAME.getFieldName(), person.getName());
        fields.put(PersonTableConstants.PHONE.getFieldName(), person.getPhone());
        fields.put(PersonTableConstants.EMAIL.getFieldName(), person.getEmail());
        return fields;
    }
}
