package fr.p10.miage.projet1.nanterasmusweb.model.DB;


import fr.p10.miage.projet1.nanterasmusweb.model.person.Admin;
import fr.p10.miage.projet1.nanterasmusweb.model.person.Personne;
import fr.p10.miage.projet1.nanterasmusweb.model.person.SuperAdmin;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class which manage the connection to the DataBase.
 * We can send requests to database through this class.
 * 
 * @author florian
 */
public final class QueryDB {
    
    /**
     * Name of the driver by default it's Oracle (defined in dbRessource.properties) 
     * but you can change to MySQL for exemple.
     */
    private String NOMDRIVER;
    
    /**
     * URL of the dataBase (defined in dbRessource.properties).
     */
    private String URLDATABASE;
    
    /**
     * Connection to DataBase.
     */
    private Connection cnx;
    
    /**
     * Prepared statement to request DataBase.
     */
    private PreparedStatement pStatement;
    
    /**
     * ResultSet to store result of requests.
     */
    private ResultSet res;
    
    /**
     * Create a connection to DataBase.
     * 
     * @param user
     *              user allow to connect to DataBase.
     * @param pwd
     *              password of the user allowed to connect to DataBase
     * 
     * @throws SQLException 
     *            Exception on connecting DataBase
     */
    public void logInDb(String user, String pwd) throws SQLException {
        cnx = DriverManager.getConnection(URLDATABASE, user, pwd);
    }
    
    /**
     * Class' Constructor, initializes all we need to request the DataBase.
     */
    public QueryDB(){
        Properties props = new Properties();

        try {
            /* get database data to connect from dbRessource.properties */
            System.out.println("!! class loader:"+QueryDB.class.getClassLoader());
            InputStream inputStream = QueryDB.class.getClassLoader().getResourceAsStream("com/myapp/struts/dbRessource.properties");
            props.load(inputStream);
         
            NOMDRIVER=props.getProperty("db.NOMDRIVER");
            URLDATABASE=props.getProperty("db.URLDATABASE");
            
            Class.forName(NOMDRIVER);
            logInDb(props.getProperty("db.USER"), props.getProperty("db.PWD"));
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QueryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     * Test if the user who wants to join his home is in the DataBase.
     * If user is referenced as a teacher and he has the good password return the Admin Instance
     * Else return null
     * 
     * @param formLogin
     *              pseudo of user who wants to join his home.
     * @param formPassword
     *              password of user who wants to join his home.
     * 
     * @return an Admin instance if user isn't a cheater else null
     */
    public Personne connectAdminQuery(String formLogin, String formPassword)
    {
        try {
            /* Request to get Admin if he exists in base */
            pStatement = cnx.prepareStatement("SELECT * FROM M1_USERS, M1_PERSONS, M1_STATUS "
                    + " WHERE STATUS = STATUS_ID AND STATUS IN (1,2) AND "
                    + " PERSON_ID = PERSON AND USER_LOGIN = ? AND USER_PASSWORD = ?");
            pStatement.setString(1, formLogin);
            pStatement.setString(2, formPassword);

            /* Get the The admin */
            res=pStatement.executeQuery();
            if (res.next()){
                if(res.getInt("STATUS_ID")==1)
                    return new SuperAdmin(formLogin,res.getString("PERSON_FIRST_NAME"),
                            res.getString("PERSON_LAST_NAME"),res.getString("USER_ID"),res.getString("PERSON_MAIL"));
                else // -> STATUS_ID==2
                    return new Admin(formLogin,res.getString("PERSON_FIRST_NAME"),
                            res.getString("PERSON_LAST_NAME"),res.getString("USER_ID"),res.getString("PERSON_MAIL"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}