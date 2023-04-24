package utils;

import io.cucumber.java.en.Given;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ReinstallConfig {

    @Given("Reinstall configuration")
    public void reinstall() {

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5000/postgres","user","password");
            CallableStatement cStmt = connection.prepareCall("call clearAllData()");
            cStmt.execute();
            cStmt = connection.prepareCall("call initializeForTests()");
            cStmt.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}


