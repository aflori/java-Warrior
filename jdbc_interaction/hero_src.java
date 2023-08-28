package jdbc_interaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class hero_src {

    private Statement requestLaunch;

    public hero_src() throws SQLException {
        String protocole = "jdbc:mysql", ip = "localhost", port = "3306", baseName = "java_warrior";
        String userAccount, userPassword;

        Connection databaseSrc = DriverManager.getConnection(protocole + "://" + ip + ":" + port + "/" + baseName, userAccount, userPassword);
        this.requestLaunch = databaseSrc.createStatement();
    }

}
