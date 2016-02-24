package fr.p10.miage.projet1.nanterasmusweb.model.DB;

import fr.p10.miage.projet1.nanterasmusweb.model.University.CategoryPage;
import fr.p10.miage.projet1.nanterasmusweb.model.University.Page;
import fr.p10.miage.projet1.nanterasmusweb.model.University.UniversityData;
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
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
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
    
    private Statement stmt;
    
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
            stmt = cnx.createStatement();
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
                            res.getString("PERSON_LAST_NAME"),res.getString("USER_ID"),res.getString("PERSON_MAIL"),res.getInt("UNIVERSITY"));
                else // -> STATUS_ID==2
                    return new Admin(formLogin,res.getString("PERSON_FIRST_NAME"),
                            res.getString("PERSON_LAST_NAME"),res.getString("USER_ID"),res.getString("PERSON_MAIL"),res.getInt("UNIVERSITY"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Personne checkLogin(String login, String pwd) throws Exception {
        Personne person=null;
        System.out.println("login:"+login+", mdp:"+pwd);

        pStatement = cnx.prepareStatement("SELECT * FROM M1_USERS, M1_PERSONS, M1_STATUS "
                    + " WHERE STATUS = STATUS_ID AND PERSON_ID = PERSON AND USER_LOGIN = ? AND USER_PASSWORD = ?");
        pStatement.setString(1, login);
        pStatement.setString(2, pwd);
        
        res=pStatement.executeQuery();
        if (res.next()) {
            person=new Personne(res.getString("PERSON_FIRST_NAME"),res.getString("PERSON_LAST_NAME"),res.getString("PERSON_MAIL"),res.getInt("UNIVERSITY"));
        }
        return person;
    }
    
    public UniversityData CheckUniversity (Integer id) throws Exception {
        UniversityData university=null;

        pStatement = cnx.prepareStatement("SELECT * FROM M1_UNIVERSITIES "
                    + " WHERE UNIV_ID = ?");
        pStatement.setInt(1, id);
        
        res=pStatement.executeQuery();
        if (res.next()) {
            university=new UniversityData(id,res.getString("ADRESSE"),res.getInt("CITY"),res.getString("WEBSITE"));
        }
        return university;
    }
    
    public void getParentCategories(UniversityData university) throws Exception
    {
        pStatement = cnx.prepareStatement("SELECT * FROM M1_CATEGORIES CAT, M1_CATEGORIES_UNIVERSITY CU " +
                                                "  WHERE CAT.CATEGORY_ID=CU.PAGE_CATEGORY AND CAT.CATEGORY_PARENT=0 AND CU.UNIVERSITY= ?");
        pStatement.setInt(1, university.getId());
        
        res=pStatement.executeQuery();
        while (res.next()) {
            university.addCategory(new CategoryPage(res.getInt("CAT_UNIV_ID"),res.getString("CATEGORY_NAME"),null));
        }
    }
    
    public void getPagesFromChildCategory(UniversityData university) throws SQLException{
        int i=0;
        String sql="SELECT * FROM M1_CATEGORIES_UNIVERSITY CU, M1_PAGES PAG WHERE CU.CAT_UNIV_ID=PAG.PAGE_CAT_UNIV_ID AND CU.CAT_UNIV_ID IN (";

        for(Map.Entry<Integer, CategoryPage> entry : university.getCategories().entrySet()) { 
             sql+=entry.getKey();
             if(i++<university.getCategories().size()-1)
                sql+=",";
        }
        sql+=")";
        System.out.println(sql);
        res=stmt.executeQuery(sql);
        
        while (res.next()) {
            System.out.println("page_id :"+res.getInt("PAGE_ID")+", title: "+res.getString("PAGE_TITLE")+", content:"+res.getString("PAGE_CONTENT"));
            university.getCategories().get(res.getInt("CAT_UNIV_ID")).addPage(new Page(res.getInt("PAGE_ID"),res.getString("PAGE_TITLE"),res.getString("PAGE_CONTENT")));   
        } 
    }
    
    public void getChildrenCategories(UniversityData university, Integer parentId) throws Exception
    {
        pStatement = cnx.prepareStatement("SELECT * FROM M1_CATEGORIES CAT, M1_CATEGORIES_UNIVERSITY CU " +
                                                "  WHERE CAT.CATEGORY_ID=CU.PAGE_CATEGORY AND CAT.CATEGORY_PARENT=? AND CU.UNIVERSITY= ?");
        pStatement.setInt(1, parentId);
        pStatement.setInt(2, university.getId());
        
        res=pStatement.executeQuery();
        while (res.next()) {
            university.addCategory(new CategoryPage(res.getInt("CAT_UNIV_ID"),res.getString("CATEGORY_NAME"),new CategoryPage(parentId)));   
        }
        getPagesFromChildCategory(university);
    }
    
}