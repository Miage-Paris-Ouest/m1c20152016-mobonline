package fr.p10.miage.projet1.nanterasmusweb.model.person;


/**
 * Model concrete class modelizes an Admin, this class extends Personne.
 * 
 * @author florian
 */
public final class Admin extends Personne {
   
    public String adminId;
    
   
    /**
     * Void constructor of Admin to be "Beanable".
     */
    public Admin(){
        super("","","","");
        adminId="";
    }
    
    public Admin(String login,String prenom,String nom,String etudiantId,String email){
        super(login,prenom,nom,email);
        this.status=PersonStatus.ADMIN;
        this.adminId=etudiantId;
    }
    
    public Admin(String prenom,String nom,String etudiantId,String email){
        super(etudiantId,prenom,nom,email);
        this.adminId=etudiantId;
    }
    
    public String getAdminId(){
        return this.adminId;
    }
    
}
