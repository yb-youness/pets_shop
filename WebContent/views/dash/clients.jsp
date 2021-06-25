
<%@page import="com.beans.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="includes/head.jsp" %>
<body>
<div class="dash">
<%@ include file="includes/nav.jsp" %>

                                 <div class="container">
                                <div class="row">
                               <div class="col">
                                
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        
                                    
                                    <div class="easion-card-title"><i class="fas fa-table"></i> Clients</div>
                                    </div></div>
                                    
                                     
                                    <div class="col">

                               </div>
                               </div>
                                </div>
                                <div class="card-body ">
                                    <table class="table table-striped table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Adresse</th>
                                                <th scope="col">company</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Role</th>
                                           </tr>
                                        </thead>
                                        <tbody>
                                       	 <c:forEach items="${listClients}" var="client">
                                            <tr>
                                                <th scope="row"><c:out value="${client.id}" /> </th>
                                                <td> <c:out value="${client.name}" /> </td>    
                                                <td> <c:out value="${client.email}" /> </td>   
                                                <td> <c:out value="${client.adresse}" /> </td>   
                                                <td> <c:out value="${client.company}" /> </td>    
                                                <td> <c:out value="${client.phone}" /> </td>  
                                                <td> <c:out value="${client.role}" /> </td>                                             
                                                <td>
                                                
                                                <a href="${pageContext.request.contextPath}/Admin?page=removeclient&id=${client.id}"  onclick="return confirm('Vous Volulez Suprimer ce client : ${client.name} ?')"><i class="far fa-trash-alt"></i></a>
                                                </td>
                                            </tr>
										</c:forEach>
	                                    </tbody>
                                    </table>
                                  
                                </div>
</div>