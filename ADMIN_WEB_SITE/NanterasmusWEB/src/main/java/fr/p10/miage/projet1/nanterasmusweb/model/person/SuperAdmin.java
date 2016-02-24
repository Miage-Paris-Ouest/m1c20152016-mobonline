package fr.p10.miage.projet1.nanterasmusweb.model.person;


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
        super("","","","",null);
    }
    
    public SuperAdmin(String login,String prenom,String nom,String superAdminId,String email, Integer universityId){
        super(login,prenom,nom,email,universityId);
        this.status=PersonStatus.SUPERADMIN;
        this.superAdminId=superAdminId;
    }
    
    public SuperAdmin(String prenom,String nom, String email,Integer universityId){
        super(prenom,nom,email,universityId);
    }
    
    public String getSuperAdminId(){
        return this.superAdminId;
    }
    
}