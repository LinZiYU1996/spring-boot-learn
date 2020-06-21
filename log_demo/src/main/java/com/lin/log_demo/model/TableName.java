package com.lin.log_demo.model;

public enum TableName {
    UNKNOWN("unknown"),
    USER("user"),
    DEPARTMENT("department");

    private final String name;

    TableName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }




}
