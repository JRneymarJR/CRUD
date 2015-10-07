import java.io.PrintStream;
import java.sql.*;


/**
 * Created by Неймар on 07.10.2015.;
 */
public class Main {

    public static int id;
    public static String pib;
    public static String payment_type;
    public static int volume;
    public static int cost;
    public static Date date;


    public static  Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;



    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
        statement = connection.createStatement();
        System.out.println("База подкдючена!");
        Main.select();

    }

    public static void select() throws ClassNotFoundException, SQLException {

        resultSet = statement.executeQuery("SELECT * FROM communal_payments");
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            pib = resultSet.getString("pib");
            payment_type = resultSet.getString("payment_type");
            volume = resultSet.getInt("volume");
            cost = resultSet.getInt("cost");
            date = resultSet.getDate("date");
            System.out.println(id+" "+pib+" "+payment_type+" "+volume+" "+cost+" "+date);
        }


    }

}


