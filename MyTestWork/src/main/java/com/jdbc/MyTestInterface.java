package com.jdbc;

import java.sql.ResultSet;

public interface MyTestInterface {

    public Boolean myBaseUpdate(String secondName, String name);

    public People myBaseSearch(String name);
}
