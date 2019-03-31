package homework2jdbc;
//Малыгин Андрей, домашнее задание к 2 уроку Java3.
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PasswordCheck extends PasswordSave{
    private static String name = "orange";
    private static String password = "54321";

    public static void main(String[] args) throws Exception {
        init();
        try (Connection connection = getConnection()) {
            passwordCheck(connection, name, password);
        }
    }

    public static boolean passwordCheck(Connection connection, String name, String password) throws Exception{
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()){
                if (name.equals(resultSet.getString(2))){
                    if (password.equals(resultSet.getString(3))){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
