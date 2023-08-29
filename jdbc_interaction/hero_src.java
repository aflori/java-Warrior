package jdbc_interaction;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import Character.*;

public class hero_src {

    private Statement requestLaunch;

    public hero_src() throws SQLException {
        String protocole = "jdbc:mysql", ip = "localhost", port = "3306", baseName = "java_warrior";
        String userAccount, userPassword;

        Connection databaseSrc = DriverManager.getConnection(protocole + "://" + ip + ":" + port + "/" + baseName, userAccount, userPassword);
        this.requestLaunch = databaseSrc.createStatement();
    }

    public List<Personnage> getHeroesSet() {
        List<Personnage> characterSet = new ArrayList<Personnage>();

        ResultSet personageList = null;
        try {
            personageList = this.requestLaunch.executeQuery("SELECT * FROM heroes;");

            while (personageList.next()) {
                Personnage extractedCharacter = null;
                String type = personageList.getString("type");

                Class<?> characterClassName = Class.forName("Character."+type);
                extractedCharacter = (Personnage) characterClassName.getConstructor().newInstance();

                extractedCharacter.setAttackPower(personageList.getInt("attackPoint"));
                extractedCharacter.setName(personageList.getString("name"));
                extractedCharacter.setLifePoint(personageList.getInt("lifePoint"));

                //no weapons/philter at the start of the game for now

                characterSet.add(extractedCharacter);
            }
        } catch (SQLException e) {
            return characterSet;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return characterSet;
    }
}
