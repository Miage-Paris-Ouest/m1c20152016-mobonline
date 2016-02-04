package fr.p10.miage.nanterasmus.controler.actions;

import fr.p10.miage.nanterasmus.controler.forms.AuthentificationForm;
import fr.p10.miage.nanterasmus.model.personne.PersonStatus;
import fr.p10.miage.nanterasmus.model.personne.Personne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * Class which manage action to do after the HTML Authentification Form 
 * is validated or not.
 * 
 * It redirect a student or a teacher to his home if he don't lie about his
 * identity
 * 
 * @author florian
 */
public class AuthentificationAction extends Action {
    
    /**
     * Add wrong-ids error and redirect the Cheater on the authentification form.
     * It's a wrond-ids error when database's data and form's data don't match.
     *
     * @param mapping
     *            mapping
     * @param request
     *            sent request
     * 
     * @return the location of the page which sends data with an error to print
     */
    public ActionForward errorLogin(ActionMapping mapping,HttpServletRequest request){
        ActionMessages errors = new ActionMessages();
        ActionMessage error = new ActionMessage("error.ids.invalid");
        errors.add("idsError",error);
        saveErrors(request.getSession(),errors);
        return mapping.getInputForward();
    }
    
    /**
     * Data treatments and call to model method to respond to the request
     *
     * @param mapping
     *            mapping
     * @param form
     *            posted form
     * @param request
     *            sent request
     * @param response
     *            response to send
     * 
     * @throws Exception 
     *            Exception on executing action
     * 
     * @return the location of the page which sends data with error if data
     * are not validated else the location of the Student's or Teacher's home page
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        /* Bean width authentification form's fields */
        AuthentificationForm f = (AuthentificationForm) form;
        
        /** 
        * At first loading on page, it redeirect you on the form page without
        * error.
        */
        /*if(f.getLogin()==null || f.getPassword()==null)
        {
            return mapping.getInputForward();  
        }*/
        
        Personne personne;
       
        personne = Personne.findAdmin(f.getLogin(), f.getPassword());
        // if data send by person doesn't match with DB Data, we print him error
        if(personne==null)
            return errorLogin(mapping,request);
        
        String statut=personne.getStatus()==PersonStatus.ADMIN?"admin":"superadmin";
        
        /*
        * Add the person created to session variable to access data in all page 
        * during the session life
        */
        HttpSession session = request.getSession();
        session.setAttribute(statut,personne);
        
        /* 
        * We redirect user on the page he asked 
        * (accueiladmin if this is an admin and accueilsuperadmin if this is a super admin) 
        */
        return mapping.findForward("accueil"+statut);
        
    }
}
