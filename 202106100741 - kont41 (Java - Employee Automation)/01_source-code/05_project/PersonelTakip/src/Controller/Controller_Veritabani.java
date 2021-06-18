package Controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//Bu sınıf genel veritabanı işlemlerinin yapılmasını sağlamaktadır
public class Controller_Veritabani {

    private String server;
    private String database;
    private String userName;
    private String password;
    private int port;

    public Controller_Veritabani(String server, String database, String userName, String password, int port) {
        this.server = server;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.port = port;
    }

    //boş constructor
    public Controller_Veritabani() {
        this.server = "localhost";
        this.database = "personelTakip";
        this.userName = "sa";
        this.password = "123456789";
        this.port = 1433;
    }

    //ilgili veritabanına bağlantıyı sağlayan  ve geriye bağlantı nesnesini döndüren method
    public Connection Baglanti() {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection conn = null;

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String dbURL = "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + database + ";encrypt=true;trustServerCertificate=true;";

            return DriverManager.getConnection(dbURL, userName, password);
        } catch (SQLException | ClassNotFoundException ex) {
           // Logger.getLogger(Controller_Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //gelen sorguyu veritabanında çalıştıran ve başarılı olup olmama durumunu geriye döndüren method
    public boolean Sorgu(String sorgu) {
        try {
            Connection conn = new Controller_Veritabani().Baglanti();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sorgu);
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

     public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
