package fr.p10.miage.nanterasmus.model.personne;

import fr.p10.miage.nanterasmus.model.db.QueryDB;

/**
 * Model abstract class modelizes a person using the application.
 * <p>A person might be a teacher (Enseignant) or a student (Etudiant)</p>
 * 
 * @see Enseignant
 * @see Etudiant
 * @author florian
 */
public abstract class Personne {
    
    /**
     * surname of the person.
     */
    protected String nom;
    
    /**
     * first name of the person.
     */
    protected String prenom;
    
    /**
     * login of the person (in Database).
     */
    protected String login;
    
    /**
     * email of the person (in Database).
     */
    protected String email;
    
    protected PersonStatus status;
    
    /**
     * Connection to DataBase.
     */
    protected static QueryDB database;
    
    /**
     * Personne's constructor with 4 parameters.
     *
     * @param login
     *              person's login
     * @param prenom
     *              person's first name
     * @param nom
     *              person's surname
     * @param email
     *              person's email
     *
     */
    public Personne(String login,String prenom,String nom, String email){
        this.login=login;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.status=PersonStatus.NOTAVAILABLE;
        database=new QueryDB();
    }
    
    public static Personne findAdmin(String login, String password){
        QueryDB db=new QueryDB();
        return db.connectAdminQuery(login, password);
    }
    
    /**
     * Personne's constructor with 3 parameters.
     *
     * @param prenom
     *              person's first name
     * @param nom
     *              person's surname
     * @param email
     *              person's email
     *
     */
    public Personne(String prenom,String nom, String email){
        this.nom=nom;
        this.prenom=prenom;
        this.email= email;
    }
    
    /**
     * Return the person's surname
     *
     * @return surname.
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Return the person's first name
     *
     * @return first name.
     */
    public String getPrenom(){
        return this.prenom;
    }
    
    /**
     * Return the person's login
     *
     * @return login.
     */
    public String getLogin(){
        return this.login;
    }
    
    /**
     * Return the person's email
     *
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    
    public PersonStatus getStatus(){
        return this.status;
    }
}
