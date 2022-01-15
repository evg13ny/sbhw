import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pl.course_name, " +
                    "COUNT(pl.subscription_date)/ " +
                    "(month(max(pl.subscription_date)) - month(min(pl.subscription_date)) + 1) AS avg_purchases_per_month " +
                    "FROM PurchaseList pl " +
                    "GROUP BY pl.course_name " +
                    "ORDER BY avg_purchases_per_month DESC");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String avgPurchases = resultSet.getString("avg_purchases_per_month");
                System.out.println(courseName + " " + avgPurchases);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
