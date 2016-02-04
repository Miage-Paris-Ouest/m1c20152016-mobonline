<%@include file="/global/directivesInclude.jsp" %>

<jsp:include page="/global/header.jsp">
    <jsp:param name="title" value='authentification.title'/>
</jsp:include>
        
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
         <h1><bean:message key="authentification.body.title"/></h1>
         <div class="row">
         <div class="col-lg-3 col-md-4 col-xs-12">
         <form method="post" role="form"  >
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control" name="login" placeholder="<bean:message key='authentification.input.pseudo'/>" 
                           value="<bean:write name='AuthentificationForm' property='login' />" />
                </div>
             </div>
             <html:errors  property="loginError"/>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" class="form-control" name="password" placeholder="<bean:message key='authentification.input.password'/>" 
                           value="<bean:write name='AuthentificationForm' property='password' />" />
                </div>
            </div>
            <html:errors  property="passwordError"/><br />
            <html:errors  property="idsError"/>
            <button class="btn btn-warning" type="submit"><i class="fa fa-paper-plane-o"></i> <bean:message key="authentification.submit"/></button>
        </form>
        </div>
         </div>
        
<jsp:include page="/global/footer.jsp" /> 