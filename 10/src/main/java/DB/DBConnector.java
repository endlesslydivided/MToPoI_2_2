package DB;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.*;

public class DBConnector {


    String connectionUrl =
            "jdbc:sqlserver://DESKTOP-A8E6OVC;"
                    + "database=USERSJAVA;"
                    + "user=booba;"
                    + "password=stayalive;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";

    public static Connection connection;


    public void SetConnection() throws SQLException  {

        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        connection = DriverManager.getConnection(connectionUrl);
    }

    public ResultSet ExecuteQuery(String query) throws SQLException{
        return connection.createStatement().executeQuery(query);
    }

    public void Execute(String query) throws SQLException{
        connection.createStatement().execute(query);
    }

    public void Insert(String table,String ... parms) throws SQLException
    {
        String query = "INSERT INTO " + table + " values ( ";
        for (String s:parms)
        {
            query += s;
            query += ",";
        }
        query += ");";
        connection.createStatement().executeQuery(query);
    }

    public void Update(String table,String parm,String value, String predicate) throws SQLException
    {
        String query = "UPDATE " + table + " SET " + parm + " = " + value + " WHERE " + predicate;
        connection.createStatement().executeQuery(query);
    }

    public void Delete(String table, String predicate) throws SQLException
    {
        String query = "DELETE " + table + " WHERE " + predicate;
        connection.createStatement().executeQuery(query);
    }

    public ResultSet Select(String predicate, String ... tables) throws SQLException
    {
        String query = "SELECT FROM ";
        int iter = 0;
        for (String s:tables)
        {
            query += s;
            iter++;
            if(tables.length != iter)
            {
                query += ",";
            }

        }
        query += " WHERE " + predicate;
        return connection.createStatement().executeQuery(query);
    }


    public void DisplayRowsConsole(ResultSet set, String sourceQuery, String ... column) throws SQLException{

        for(int iter = 0;iter < column.length;iter++)
        {
            System.out.print(column[iter] + "       ");
        }
        System.out.println();
        int quantity = 0;
        while (set.next()){
            for(int iter = 0;iter < column.length;iter++)
            {
                System.out.print(set.getString(column[iter]) + "            ");
            }
            System.out.println();
            quantity++;
        }

    }

    public void CloseConnection() throws SQLException{
        connection.close();
    }}