<% request.setAttribute("title", "Home"); %> 
<%@ include file="../includes/header.jsp" %>
<div class="left_content">
            <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath}/views/images/bullet1.gif" alt="" title="" /></span>Featured pets</div>
        <c:forEach items="${listproducts}" var="prod">
        	<div class="feat_prod_box">
              
            	<div class="prod_img"><a href="details.html"><img style="width: 100%;" src="data:image/png;base64,${prod.image}" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">${prod.nom}</div>
                    <p class="details">${prod.description}</p>
                    <div class="price"><strong>CATEGORIE:</strong> <span class="red">${prod.libele}</span></div>
                     <div class="price"><strong>PRICE:</strong> <span class="red">${prod.prix} $</span></div>
                    <div class="price"><strong>COLORS: ${prod.couleur}</strong> 
                    <span class="colors"><img src="images/color1.gif" alt="" title="" border="0" /></span>
                    <span class="colors"><img src="images/color2.gif" alt="" title="" border="0" /></span>
                    <span class="colors"><img src="images/color3.gif" alt="" title="" border="0" /></span>                    </div>
                    
                   
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
             
            
                        </c:forEach>            
        <button id="myBtn" class="more">- ORDER -</button>
				<!-- The Modal -->
				<div id="myModal" class="modal">
				
				  <!-- Modal content -->
				  <div class="modal-content">
				    <span class="close">&times;</span>
				    <p> <center>for ordering the best pets quality you most come to our shop
				    ADDRESS
								
					Street 3831  Stoneybrook Road <br>
								City Kissimmee <br>
								State FL State Full Florida <br>
								Zip Code 34741 <br>
								Phone Number 321-697-5218 <br>
								Mobile Number 407-780-2299 <br><center/>
												     </p>
				  </div>
				
				</div>
				
            
            
             <div class="pagination">
             <c:if test="${currentPage != 1}">
            <a href="shop?page=home&p=${currentPage - 1}" ><<</a>
             </c:if>
             
             <c:forEach begin="1" end="${noOfPages}" var="i">
              <c:choose>
              <c:when test="${currentPage eq i}">
            <span class="current">${i}</span>
             </c:when>
             
             <c:otherwise>
            <a href="shop?page=home&p=${i}">${i}</a>
            </c:otherwise>
            </c:choose>
             </c:forEach>
            
            <c:if test="${currentPage lt noOfPages}">
            <a href="shop?page=home&p=${currentPage + 1}">>></a>
            </c:if>
            </div> 
            
            
          
            
        <div class="clear"></div>
        </div>
        <!--end of left content-->
        
       
        <%@ include file="../includes/right.jsp" %>
        
        
       
       
       <div class="clear"></div>
       <!--end of center content-->
        
               

        <%@ include file="../includes/footer.jsp" %>
        
        
       
      
        
        
 
</body>


</html>

<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>