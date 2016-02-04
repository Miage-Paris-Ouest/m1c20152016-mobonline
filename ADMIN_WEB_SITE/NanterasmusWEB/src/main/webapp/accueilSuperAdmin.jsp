<%-- 
    Document   : accueilSuperAdmin
    Created on : 11 déc. 2015, 01:13:19
    Author     : florian
--%>

<%@page import="fr.p10.miage.projet1.nanterasmusweb.model.person.SuperAdmin"%>

<%
    SuperAdmin superAdmin=session.getAttribute("superadmin")==null?null:(SuperAdmin)session.getAttribute("superadmin");
    
    /* If superadmin is null it's a not a connected person */
    if( superAdmin == null )
    {
        response.sendRedirect("index.jsp"); 
    }
    else /* Else for use jsp:getProperty, if no else -> opetation on null object */
    {
%>
        <%@include file="global/directivesInclude.jsp" %>

        <jsp:include page="global/header.jsp">
            <jsp:param name="title" value="accueil.superadmin.title"/>
        </jsp:include>
                 <h1><bean:message key="accueil.superadmin.body.title"/> <%= superAdmin.getPrenom()+" "+superAdmin.getNom() %>!</h1>
                 
         <jsp:include page="global/footer.jsp" />
<%
    }
%>
