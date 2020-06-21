package com.lin.log_demo.model;

public enum IdName {

    UNKNOWN("unknown"),
    USERID("userId"),
    DEPARTMENTID("departmentId");

    private final String name;

    IdName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}
