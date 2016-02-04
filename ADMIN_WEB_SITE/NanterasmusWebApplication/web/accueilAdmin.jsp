<%-- 
    Document   : notesEtudiant
    Created on : 11 d�c. 2015, 00:28:25
    Author     : florian
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<a href="accueilAdmin.jsp"></a>
<%@page import="fr.p10.miage.nanterasmus.model.personne.Admin"%>

<%
    Admin admin=session.getAttribute("admin")==null?null:(Admin)session.getAttribute("admin");
    
    /* If admin is null it's a not a connected person */
    if( admin == null )
    {
        response.sendRedirect("index.jsp"); 
    }
    else/* Else for use jsp:getProperty, if no else -> opetation on null object */
    {
%>
    <%@include file="global/directivesInclude.jsp" %>

    <jsp:include page="global/header.jsp">
        <jsp:param name="title" value="accueil.admin.title"/>
    </jsp:include>

            <h1> 
                <bean:message key="accueil.admin.body.title"/> <%= admin.getPrenom()+" "+admin.getNom() %>!
            </h1>
            
    <jsp:include page="global/footer.jsp" /> 