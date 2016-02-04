package fr.p10.miage.projet1.nanterasmusweb.WEBAPP.controler.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 * Class which disconnect user with the session invalidation.
 * After the log out, the user is redirected to the authentification page
 * 
 * @author florian
 */
public class LogOutAction extends DispatchAction {
    
    /**
     * Log out the user and redirect him to authentification page
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
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        if (!session.isNew()) {
            session.invalidate();
        }
        return mapping.findForward("success");
    }
    
}