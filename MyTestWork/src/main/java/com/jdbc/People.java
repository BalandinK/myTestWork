package com.jdbc;

import java.sql.*;

public class People implements  MyTestInterface{
    //Настройки для подключения к базе данных
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/test_db?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //Поля для хранения данных учётной записи
    private int tableId;
    private String tableSecondName;
    private String tableName;

    //Конструкторы класса
    public People(){}
    public People(int tableId, String tableSecondName, String tableName){
        this.tableId = tableId;
        this.tableSecondName = tableSecondName;
        this.tableName = tableName;
    }

    //Переопределение метода toString для класса People
    @Override
    public String toString(){
        return "Учётная запись: "+tableName+"\nФамилия: "+tableSecondName+"\nИдентификатор: "+tableId;
    }


    //Переопределение функции для поиска в репозитории учётной записи
    //В случае если данной учётной записи не найдено вернётся id = 0 second_name = null name = null
    @Override
    public People myBaseSearch(String name) {
        String query = "SELECT * FROM people WHERE name = \""+name+"\"";
        int resId = 0;
        String resSecName = null;
        String resName = null;
        People ppl1 = new People();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stm = connection.createStatement()){
            ResultSet result = stm.executeQuery(query);

            while(result.next()){
                resId = result.getInt("id");
                resSecName = result.getString("second_name");
                resName = result.getString("name");
            }

            People ppl = new People(resId, resSecName, resName);
            System.out.println(ppl);

            //Если учётной записи не существует возвращаемое значение null
            if(ppl.tableName != null) {
                ppl1 = ppl;
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ppl1;
    }

    //Переопределение метода для изменения у учётной записи фамилии
    public Boolean myBaseUpdate(String secondName, String name) {
        Boolean result = false;
        String query = "UPDATE people SET second_name=\""+secondName+"\" WHERE name=\""+name+"\"";
        String info;
        People ppl = new People();

        //Проверка есть ли в базе данных УЗ с именем name

        if(ppl.myBaseSearch(name).tableName != null) {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement()) {

                statement.executeUpdate(query);

                info = "У УЗ: " + name + " изменена фамилия на: " + secondName;
                System.out.println(info);
                result = true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("УЗ с именем: "+name+" не существует!!!");
        }
        return result;
    }

    public int getTableId() {
        return tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableSecondName() {
        return tableSecondName;
    }
}
