package com.jdbc;

import java.sql.*;

public class PeoplePersistenceService {

    //Настройки для подключения к базе данных
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/test_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Object[] queryByName(String name) {
        String query = "SELECT * FROM people WHERE name = \""+name+"\"";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stm = connection.createStatement()) {
            ResultSet result = stm.executeQuery(query);

            Object[] resultObject = new Object[3];
            while (result.next()) {
                resultObject[0] = result.getInt("id");
                resultObject[1] = result.getString("second_name");
                resultObject[2] = result.getString("name");
            }

            return resultObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateByName(String name, String second_name){
        boolean res = false;
        String query = "UPDATE people SET second_name=\""+second_name+"\" WHERE name=\""+name+"\"";
        People ppl = new People();

        if(ppl.myBaseSearch(name).getTableName() != null) {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stm = connection.createStatement()) {
                ResultSet result = stm.executeQuery(query);

                return res = true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        } else {
            return res;
        }
    }
}
