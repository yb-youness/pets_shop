<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="includes/head.jsp" %>
<body>
<div class="dash">
<%@ include file="includes/nav.jsp" %>
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-table"></i>
                                    </div>
                                    <div class="easion-card-title">Products</div>
                                    <div class="float-right">
                                 <a href="${pageContext.request.contextPath}/Admin?page=addprod" class="btn btn-primary"><i class="fas fa-plus"></i> Ajouter</a>
                                 </div>
                                </div>
                                <div class="card-body ">
                                    <table class="table table-striped table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">CATEGORY</th>
                                                <th scope="col">NOM</th>
                                                <th scope="col">IMAGE</th>
                                                <th scope="col">DESCRIPTION</th>
                                                <th scope="col">PRIX</th>
                                                <th scope="col">QUANTITE</th>
                                                <th scope="col">COULEUR</th> 
                                          	   <th scope="col">ACTION</th>    
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listproducts}" var="prod">
                                            <tr>
									       <td>${prod.id}</td>
								         <td>${prod.libele}</td>
									          <td>${prod.nom}</td>
									           <td><img style="width: 50%;" src="data:image/png;base64,${prod.image}"></td>
									            <td>${prod.description}</td>
									             <td>${prod.prix}</td>
									              <td>${prod.quantite}</td>
									            <td>${prod.couleur}</td>
									 <td> <a href="${pageContext.request.contextPath}/Admin?page=oneprod&lang=${prod.id}"><i class="fas fa-edit"></i></a> <a href="${pageContext.request.contextPath}/Admin?page=removeprod&lang=${prod.id}"  onclick="return confirm('Vous Volulez Suprimer le produit : ${prod.nom} ?')"><i class="far fa-trash-alt"></i></a></td>
                                            </tr>			               
										
												               						
					    					</c:forEach>
                            			      
                            			      
 <ul class="pagination pagination-lg">
  <!-- This to Dislay the prev page -->
   <c:if test="${currentPage != 1}">
    <li class="page-item">
      <a class="page-link" href="Admin?page=listproduct&p=${currentPage - 1}">&laquo;</a>
    </li>
    </c:if>
     <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                    <li class="page-item active">
                      <a class="page-link" href="#">${i}</a>
                   </li>
                    </c:when>
                    <c:otherwise>
                    <li class="page-item active">
                      <a class="page-link" href="Admin?page=listproduct&p=${i}">${i}</a>
                   </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
    <!-- To display next page -->
    <c:if test="${currentPage lt noOfPages}">
    <li class="page-item">
      <a class="page-link" href="Admin?page=listproduct&p=${currentPage + 1}">&raquo;</a>
    </li>
    </c:if>
  </ul>
   			      
		           
           </tbody>
       </table>
   </div>
      <div class="modal fade" role="dialog" id="imgmodal">
    <div class="modal-dialog">
        <div class="modal-content"></div>          
                    <img class="img-responsive" style="width: 100%;" src="" id="show-img">         
        </div> </div>  
</div>

<script>
$(document).ready(function(){
    $("img").click(function(){
       var img=$(this).attr('src');
         $("#show-img").attr('src',img);
         $("#imgmodal").modal('show');
    });
});
</script>