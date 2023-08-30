package jdbc_interaction;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.lang.reflect.InvocationTargetException;

import java.util.List;
import java.util.ArrayList;

import Character.*;
import Exception.HeroException;


public class hero_src {

    private final Statement requestLaunch;

    /**
     *
     * @throws HeroException
     */
    public hero_src() throws HeroException {
        String protocole = "jdbc:mysql", ip = "localhost", port = "3306", baseName = "java_warrior";
        String userAccount, userPassword;

        try {
            InputStream customEnv = ClassLoader.getSystemClassLoader().getResourceAsStream(".env");
            Properties prop = new Properties();
            prop.load(customEnv);


            userAccount = prop.getProperty("database.username");
            userPassword = prop.getProperty("database.password");
        } catch (IOException e) {
            System.err.println("Database not configured!");
            throw new HeroException("");
        }


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new HeroException(e);
        }
        Connection databaseSrc = null;
        try {
            databaseSrc = DriverManager.getConnection(protocole + "://" + ip + ":" + port + "/" + baseName, userAccount, userPassword);
            this.requestLaunch = databaseSrc.createStatement();
        } catch (SQLException e) {
            throw new HeroException(e);
        }
    }

    public List<Personnage> getHeroesSet() throws HeroException {
        List<Personnage> characterSet = new ArrayList<Personnage>();

        ResultSet personageList = null;
        try {
            personageList = this.requestLaunch.executeQuery("SELECT * FROM heroes;");

            while (personageList.next()) {
                Personnage extractedCharacter = null;
                String type = personageList.getString("type");

                Class<Personnage> characterClassName = (Class<Personnage>) Class.forName("Character." + type); // Character.Magicien or Character.Guerrier
                extractedCharacter = characterClassName.getConstructor().newInstance();

                extractedCharacter.setName(personageList.getString("name"));
                extractedCharacter.setAttackPower(personageList.getInt("attackPoint"));
                extractedCharacter.setLifePoint(personageList.getInt("lifePoint"));

                //no weapons/philter at the start of the game for now

                characterSet.add(extractedCharacter);
            }
        } catch (SQLException e) {
            return characterSet;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new HeroException(e);
        }

        return characterSet;
    }
}
