package fr.p10.miage.nanterasmus.model.personne;


/**
 * Model concrete class modelizes a SuperAdmin, this class extends Personne.
 * 
 * @author florian
 */
public final class SuperAdmin extends Personne{
    
    public String superAdminId;
    
    
    /**
     * Void constructor of SuperAdmin to be "Beanable".
     */
    public SuperAdmin(){
        super("","","","");
    }
    
    public SuperAdmin(String login,String prenom,String nom,String superAdminId,String email){
        super(login,prenom,nom,email);
        this.status=PersonStatus.SUPERADMIN;
        this.superAdminId=superAdminId;
    }
    
    public SuperAdmin(String prenom,String nom, String email){
        super(prenom,nom,email);
    }
    
    public String getSuperAdminId(){
        return this.superAdminId;
    }
    
}