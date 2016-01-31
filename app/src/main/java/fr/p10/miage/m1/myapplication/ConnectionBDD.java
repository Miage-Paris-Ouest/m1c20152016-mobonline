package fr.p10.miage.m1.myapplication;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by adrie_000 on 30/01/2016.
 */
public class ConnectionBDD {

    private Connection conn;
    private Statement stmt;
    public ConnectionBDD() throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521";
            this.conn = DriverManager.getConnection(url,"root","root");
            this.conn.setAutoCommit(false);
            this.stmt = this.conn.createStatement();
        } catch(SQLException e) {
            Log.d("tag", e.getMessage());
        }
    }
    public ResultSet selectResult(String request) throws SQLException {
        ResultSet rset = stmt.executeQuery(request);
        stmt.close();
        return rset;
    }

}
