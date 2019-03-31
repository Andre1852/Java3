package homework2jdbc;

import java.sql.*;
//Малыгин Андрей, домашнее задание к 2 уроку Java3.
public class PasswordSave {
    public static void main(String[] args) throws Exception {
        init();
        try (Connection connection = getConnection()) {
            createDataBase(connection);
            saveData(connection);
        }
    }

    public static void init() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");//выбор драйвера
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:test.db");//URL -для нахождения базы данных
    }
    public static void createDataBase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create table user(" +
                    "id integer primary key auto_increment, " +
                    "name varchar(100), " +
                    "password varchar(100));");// создать таблицу с колонками id, name, password
        }
    }
    public static void saveData(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection
                .prepareStatement("insert into user(name,password) values(?,?)")) {
            //для заполнения поля id используется auto_increment
            statement.setString(2, "apple");
            statement.setString(3, "12345");
            statement.executeUpdate();// Выполнение единичного запроса INSERT
        }
    }
}
