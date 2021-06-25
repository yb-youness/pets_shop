
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Check If the Cookies  Value of the lang is Set if Not Load eng by Default  -->
 <c:set var="curentlang"
    value="${not empty cookie.curentlang.value ? cookie.curentlang.value :'fr'}"
    scope="session"/>
  <fmt:setLocale value="${curentlang}" /> 
<fmt:setBundle basename="com.conf.project.labeles.labeles" />
 <c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="${curentlang}">
<head>
<meta charset="ISO-8859-1" >
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Petshop | <%= request.getAttribute("title")%></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/styles.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/lightbox.css"/>
</head>
<body>
<div id="wrap">
       <div class="header">
       		<div class="logo"><a href="${context}/shop?page=home"><img src="${pageContext.request.contextPath}/views/images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="${context}/shop?page=home"><fmt:message key="nav.homp" /></a></li>
           
<%--             <li><a href="${context}/shop?page=category"><fmt:message key="nav.pets" /></a></li> --%>
          <%--   <li><a href="${context}/shop?page=specials"><fmt:message key="nav.specialp" /></a></li> --%>
            <% 
		        //Check if the  Session  is Set 
		          if(request.getSession().getAttribute("roole")==null){
		     %>
            <li><a href="${context}/shop?page=myaccount"><fmt:message key="nav.maccount" /></a></li>
            <li><a href="${context}/shop?page=register"><fmt:message key="nav.register" /></a></li>
            <%} %>
           <%--  <li><a href="${context}/shop?page=details"><fmt:message key="nav.price" /></a></li> --%>
              
            <li><a href="${context}/shop?page=contact"><fmt:message key="nav.contact" /></a></li>
		            <% 
		        //Check if the  Session  is Set 
		          if(request.getSession().getAttribute("roole")!=null){
		     %>
            <li><a href="${context}/login?page=deconect"><fmt:message key="nav.decon" /></a></li>  
                 <% } %>
                 
                          <% 
		        //Check if the  Session  is Set 
		          if(request.getSession().getAttribute("roole")=="admin"){
		     %>
            <li><a href="${context}/Admin?page=index"><fmt:message key="nav.dash" /></a></li>  
                 <% } %>   
            
            </ul>
        </div>     
           </div>