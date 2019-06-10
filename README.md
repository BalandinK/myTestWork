# myTestWork
В данном проекте описан класс People в котором реализованы 2 метода: поиск учётной записи по уникальному ключу (name) и изменение фамилии (second_name) у учётной записи. 
Подключение к базе данных (СУБД MySQL) идёт через JDBC. Объекты connection создаются внутри метода в try-catch с ресурсами, что позволяет нам быть уверенными, что будет выполнено закрытие соединения.
Используется Maven.
В качестве базы данных используется test_db (MySQL Server 8.0) и таблица people (id, name UNIQUE, second_name)
