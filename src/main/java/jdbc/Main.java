package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main
{
    public static void main(String[] args)
    {
        loadDbDriver();
        Connection dbConnection = getDbConnection();
        runQuery(dbConnection);
        insertData(dbConnection);
    }

    private static void insertData(Connection dbConnection)
    {
        PreparedStatement ps = null;
        try {
            ps = dbConnection.prepareStatement("insert into authors(id, name) values (?, ?)");
            ps.setInt(1, 6);
            ps.setString(2, "CTP");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Cannot insert author: " + e.getMessage());
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException e) { }
        }
    }

    private static void runQuery(Connection conn)
    {
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;
        final String format = "%20s%20s\n";
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from authors");  // plain SQL statement
            boolean hasResults = rs.next();  // position on the first line (initially it’s at -1)
            if (hasResults) {
                System.out.format(format, "Name", "Email");
                do {
                    System.out.format(format, rs.getString("id"), rs.getString("name"));
                } while (rs.next());
            } else {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            System.err.println("Cannot execute query: " + e.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {  }
            if (st != null) try { st.close(); } catch (SQLException e) {  }
//            try { conn.close(); } catch (SQLException e) { }   // optional. We might reuse the same connection
        }
    }

    private static Connection getDbConnection()
    {
        DriverManager.setLoginTimeout(60);  // wait 1 min; optional: DB may be busy, good to set a higher timeout
        try {
            String url = "jdbc:" +
                    "postgresql" +       // “mysql” / “db2” / “mssql” / “oracle” / ...
                    "://" +
                    "localhost" +
                    ":" +
                    "5432" +
                    "/" +
                    "books" +
                    "?user=" +
                    "postgres" +
                    "&password=" +
                    "admin";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
        return null;
    }

    private static void loadDbDriver()
    {
        try {
//            DriverManager.registerDriver(new org.postgresql.Driver());
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }
    }
}
