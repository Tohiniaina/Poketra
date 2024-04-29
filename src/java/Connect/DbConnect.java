/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tohy
 */
public class DbConnect {
    public DbConnect() {
    }
    
    public Connection ConnectPostgres() throws Exception {
        Connection c = null;
        String url = "jdbc:postgresql://localhost:5432/poketra";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, "postgres", "postgres");
            System.out.println(url);
        } catch (Exception e) {
            throw e;
        }
        return c;
    }
}
