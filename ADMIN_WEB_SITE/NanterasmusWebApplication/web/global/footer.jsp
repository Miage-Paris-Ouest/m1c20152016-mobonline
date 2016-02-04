<%-- 
    Document   : footer
    Created on : 12 déc. 2015, 02:24:49
    Author     : florian
--%>
<%@include file="directivesInclude.jsp" %>
                                <div class="footer">
                                    <%
                                        if( session.getAttribute("admin") != null ||  session.getAttribute("superAdmin") != null) {
                                    %>
                                        <a href="logOut.do"><i class="fa fa-sign-out"></i> 
                                            <bean:message key="footer.logout"/>
                                        </a>
                                    <%
                                        }
                                    %>
                                    <p class="credits">
                                        <br />
                                        <a href="https://miage.u-paris10.fr/"><img src='./ressources/images/logoParisOuestTransp.png'></a>
                                        <p class="pull-right"><bean:message key="footer.developp"/> <a href="mailto:florianroy@laposte.net">Florian ROY</a>,<a href="bru.veraldi@hotmail.fr">Bruno VERALDI, <a href="mailto:adriendossantos29@gmail.com">Adrien DOS SANTOS</a></a></p>
                                    </p>
                                </div>
                           </div>
                        </div>		        
                    </div>
		</div>
            </div>
        </div>
    </body>
</html>
