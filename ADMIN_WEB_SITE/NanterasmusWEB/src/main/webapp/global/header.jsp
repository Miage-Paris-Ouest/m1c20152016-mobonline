<%-- 
    Document   : header
    Created on : 12 déc. 2015, 02:24:36
    Author     : florian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="directivesInclude.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key='<%= request.getParameter("title")%>'/></title>
        <!-- Local : Latest Bootstrap compiled and minified CSS -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/ressources/CSS/Bootsrap/bootstrap.min.css">
        <!-- Local : Font awesome to display awesome icons  -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/ressources/CSS/font-awesome/css/font-awesome.min.css">
        
        <link rel="stylesheet" href="<%=request.getContextPath()%>/ressources/CSS/flag-icon-css-master/assets/docs.css" type="text/css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/ressources/CSS/flag-icon-css-master/css/flag-icon.css" type="text/css">
        <!-- Local : My Custom CSS -->
        <link href="<%=request.getContextPath()%>/ressources/CSS/style.css" rel="stylesheet" type="text/css">
        
        <!-- Local : Jquery for Bootsrap... -->
        <script src="<%=request.getContextPath()%>/ressources/JavaScript/jQuery/jquery-1.9.1.min.js"></script>
        <!-- Local : Amcharts JavaScript to display Graphs -->
        <script src="<%=request.getContextPath()%>/ressources/JavaScript/amcharts/amcharts.js" /></script>
        <script src="<%=request.getContextPath()%>/ressources/JavaScript/amcharts/serial.js" /></script>
        <script src="<%=request.getContextPath()%>/ressources/JavaScript/amcharts/radar.js"></script>
        <!-- Local : Latest compiled and minified JavaScript -->
        <script src="<%=request.getContextPath()%>/ressources/CSS/Bootsrap/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-xs-12">
                <div class="main">
                    <div class="row">
                        <div class="col-xs-12 col-md-12 col-lg-12">
                            <p class="pull-right">
                                <bean:message key="header.select.lang"/>
                                <a href="changeLanguage.do?lang=english"><span class="flag-icon flag-icon-gb"></span> <bean:message key="header.select.lang.en"/></a>,
                                <a href="changeLanguage.do?lang=french"><span class="flag-icon flag-icon-fr"></span> <bean:message key="header.select.lang.fr"/></a>
                            </p>
                            <br />