package fr.p10.miage.projet1.nanterasmusweb.WEBAPP.controler.actions;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 * Class which manage the change of language.
 * After the switch of language, the user is redirected to the authentification page
 * 
 * @author florian
 */
public class LanguageAction extends DispatchAction {
    
    /**
     * Change language to English and redirect user to authentification page
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
     *            Exception on forwarding action
     * 
     * @return the location of the authentification page
     */
    public ActionForward english(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("org.apache.struts.action.LOCALE", Locale.ENGLISH);
        return mapping.findForward("success");
    }
    
    /**
     * Change language to French ans forward person to authentification page
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
     *            Exception on forwarding action
     * 
     * @return the location of the authentification page
     */
    public ActionForward french(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("org.apache.struts.action.LOCALE", Locale.FRENCH);
        return mapping.findForward("success");
    }
    
}