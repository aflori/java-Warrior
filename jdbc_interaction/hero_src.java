package jdbc_interaction;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import Character.*;

public class hero_src {

    private Statement requestLaunch;

    public hero_src() throws SQLException {
        String protocole = "jdbc:mysql", ip = "localhost", port = "3306", baseName = "java_warrior";
        String userAccount, userPassword;

        Connection databaseSrc = DriverManager.getConnection(protocole + "://" + ip + ":" + port + "/" + baseName, userAccount, userPassword);
        this.requestLaunch = databaseSrc.createStatement();
    }

    public Set<Personnage> getHeroesSet() {
        Set<Personnage> characterSet = new HashSet<Personnage>();

        ResultSet personageList = null;
        try {
            personageList = this.requestLaunch.executeQuery("SELECT * FROM heroes;");

            while (personageList.next()) {
                Personnage extractedCharacter = null;
                String type = personageList.getString("type");
                if (type.equals("magician")) {
                    extractedCharacter = new Magicien();
                } else {
                    extractedCharacter = new Guerrier();
                }
                extractedCharacter.setAttackPower(personageList.getInt("attackPoint"));
                extractedCharacter.setName(personageList.getString("name"));
                extractedCharacter.setLifePoint(personageList.getInt("lifePoint"));

                //no weapons/philter at the start of the game for now

                characterSet.add(extractedCharacter);
            }
        } catch (SQLException e) {
            return characterSet;
        }

        return characterSet;
    }
}