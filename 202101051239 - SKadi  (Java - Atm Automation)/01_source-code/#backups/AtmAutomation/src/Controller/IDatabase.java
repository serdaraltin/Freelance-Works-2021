
package Controller;

import java.sql.Connection;

public interface IDatabase {
    public boolean Query(String query);
    public boolean CreateTables();
    public Connection Connection();
    public boolean FactoryReset();
}
