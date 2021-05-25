package by.kovalev.dbconstants;

public enum PersonTableConstants {
    ID("id"),
    NAME("name"),
    PHONE("phone"),
    EMAIL("email");
    private String fieldName;

    private PersonTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldName() {
        return fieldName;
    }
}