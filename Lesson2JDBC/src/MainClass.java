import java.sql.*;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = conn.createStatement();

            stmt.execute("DELETE FROM Students"); // Очищаем таблицу

            conn.setAutoCommit(false); // Выключаем AutoCommit
            ps = conn.prepareStatement("INSERT INTO Students (Name, Age, 'Group', Score) VALUES (?, ?, ?, ?)"); // Подготовка запроса
            ps.setString(1, "S1");
            ps.setInt(2, 8);
            ps.setString(3, "T1");
            ps.setInt(4, 8);
            ps.executeUpdate(); // Выполнение единичного запроса INSERT

            // Пакетное выполнение запросов
            ps.clearBatch();
            ps.setString(1, "QWE");
            ps.setInt(2, 22);
            ps.setString(3, "Tbz11");
            ps.setInt(4, 88);
            ps.addBatch();
            ps.setString(1, "QWE23");
            ps.setInt(2, 22);
            ps.setString(3, "Tbz11");
            ps.setInt(4, 88);
            ps.addBatch();
            ps.setString(1, "QWE44");
            ps.setInt(2, 22);
            ps.setString(3, "Tbz11");
            ps.setInt(4, 88);
            ps.addBatch();
            int[] w = ps.executeBatch();
            System.out.println(Arrays.toString(w));
            conn.commit(); // Подтверждение всех изменений в базе

            // Подготовка и выполнение запроса на чтение данных
            String sqlRead = "SELECT * FROM Students";
            ResultSet rs = stmt.executeQuery(sqlRead);
            while (rs.next()) {
                System.out.print(rs.getString("Name") + ": " + rs.getInt("Score") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

    }
}
