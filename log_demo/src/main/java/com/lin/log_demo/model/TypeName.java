package com.lin.log_demo.model;

public enum TypeName {

    UNKNOWN("unknown"),
    INSERT("insert"),
    UPDATE("update"),
    DELETE("delete");

    private final String name;

    TypeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }




}
