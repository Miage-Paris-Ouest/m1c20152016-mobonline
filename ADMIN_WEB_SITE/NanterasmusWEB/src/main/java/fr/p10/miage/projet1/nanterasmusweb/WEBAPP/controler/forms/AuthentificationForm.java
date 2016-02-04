package fr.p10.miage.projet1.nanterasmusweb.WEBAPP.controler.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Class bean which stores data from the HTML Authentification Form 
 * and treate erros.
 * 
 * @author florian
 */
public class AuthentificationForm extends ActionForm{
    
    /**
     * Login of the user who wants to be authentified.
     *
     * @see AuthentificationForm#getLogin()
     * @see AuthentificationForm#setLogin(String)
     */
    private String login;
    
    /**
     * Password of the people who wants to be authentified.
     *
     * @see AuthentificationForm#getPassword()
     * @see AuthentificationForm#setPassword(String)
     */
    private String password;
    
    
    /**
     * Void constructor AuthentificationForm.
     *
     * @see AuthentificationForm#login
     * @see AuthentificationForm#statut
     * @see AuthentificationForm#password
     */
    public AuthentificationForm() {
    }
    
    /**
     * Set the login of the person, auto called by bean at post.
     *
     * @param login
     *            new login of the person
     */
    public void setLogin(String login) {
        this.login = login;
    }
    
    /**
     * Return the Login of the person
     *
     * @return login of the person.
     */
    public String getLogin() {
        return login;
    }
    
    
    /**
     * Return the password of the person
     *
     * @return password of the person.
     */
    public String getPassword(){
        return this.password;
    }
    
    /**
     * Set the password of the person, auto called by bean at post.
     *
     * @param password
     *            new password of the person
     */
    public void setPassword(String password){
        this.password=password;
    }
    
    /**
     * Validates the Authentification's form fields.
     * <p>
     *     if fields are not right, the function returns a list of the errors.
     * </p>
     * 
     * @param mapping
     *              acction mapping
     * @param request
     *              sent request
     * 
     * @return Errors in posted fields.
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
       ActionErrors errors = new ActionErrors();
       
       if (login == null || login.length() < 1) {
          errors.add("loginError",new ActionMessage("error.login.required"));
       }
       if (password == null || password.length() < 1) {
           errors.add("passwordError",new ActionMessage("error.password.required"));
       }
       return errors;
    }
}
