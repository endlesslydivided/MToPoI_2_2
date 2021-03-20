package connector;

import org.apache.log4j.Logger;

import java.sql.*;

public class DBConnector {

    public final String SELECT_ALL_PLANETS_WITH_LIFE = "SELECT PLANETS.NAMES,PLANETS.RADIUS,PLANETS.TEMPERATURE, PLANETS.HAVE_LIFE,PLANETS.HAVE_ATMOSPHERE,SATELLITES.NAMES as SatelliteName FROM PLANETS INNER JOIN SATELLITES ON PLANETS.NAMES = SATELLITES.PLANET WHERE HAVE_LIFE=?";
    public final String MIN_RADIUS_MAX_SATELLITES = "SELECT o.NAMES,[Минимальный радиус],isnull([Количество спутников],0) [Количество спутников] FROM (SELECT TOP 1 NAMES, RADIUS [Минимальный радиус] FROM PLANETS rt  order by RADIUS asc) o left outer join (SELECT SATELLITES.PLANET, count(*) [Количество спутников] from SATELLITES \n" +
            "group by SATELLITES.PLANET) s\n" +
            "\t\tON o.NAMES = s.PLANET;";
    public final String PLANET_WITH_SATELLITE_RADIUS_MAX_SUM = "SELECT TOP 1 rt1.NAMES,[Сумма радиусов] from (SELECT PLANETS.NAMES, sum(SATELLITES.RADIUS)[Сумма радиусов] FROM PLANETS inner JOIN SATELLITES on PLANETS.NAMES = SATELLITES.PLANET GROUP BY PLANETS.NAMES) rt1 order by [Сумма радиусов] desc;";



    public final String NAME_COL = "NAMES";
    public final String RADIUS_COL = "RADIUS";
    public final String AVG_COL = "TEMPERATURE";
    public final String ATM_COL = "HAVE_ATMOSPHERE";
    public final String LIFE_COL = "HAVE_LIFE";
    private static final Logger log = Logger.getLogger(DBConnector.class);

    String connectionUrl =
            "jdbc:sqlserver://DESKTOP-A8E6OVC;"
                    + "database=PLANETS_OOP;"
                    + "user=booba;"
                    + "password=sitinsilence;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";

    public static Connection connection;

    public void SetConnection() throws SQLException {
        connection = DriverManager.getConnection(connectionUrl);
    }

    public ResultSet ExecuteQuery(String query) throws SQLException{
        return connection.createStatement().executeQuery(query);
    }

    public void DisplayRows(ResultSet set, String sourceQuery, String ... column) throws SQLException{
        System.out.println("Источник запроса: " + sourceQuery);
        log.info("Источник запроса: " + sourceQuery);

        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬Результирующий набор▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
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
        System.out.println();
        log.info("Количество записей результирующего набора данного запроса: " + quantity);
    }

    public void CloseConnection() throws SQLException{
        connection.close();
    }}
