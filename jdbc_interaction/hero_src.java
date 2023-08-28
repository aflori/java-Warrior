package jdbc_interaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class hero_src {

    public hero_src() {
        try {
            String protocole = "jdbc:mysql", ip = "localhost", port = "3306", baseName = "java_warrior";
            String userAccount, userPassword;


            Connection databaseSrc = DriverManager.getConnection(protocole + "://" + ip + ":" + port + "/" + baseName, userAccount, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
