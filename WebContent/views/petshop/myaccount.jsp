
<% request.setAttribute("title", "MyAcount");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
if(request.getSession().getAttribute("roole")!=null){
	  response.sendRedirect(request.getContextPath()+"/");
       
}

%> 
		<%@ include file="../includes/header.jsp" %>


 <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath}/views/images/bullet1.gif" alt="" title="" /></span>My account</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
            </p>
            
              	<div class="contact_form">
                <div class="form_subtitle">login into your account</div>
                 <% if (request.getParameter("msg")!=null) {%>
                 <!-- Ajouter css Class  -->
                  <h1>Inavlide Login or Pass !</h1>
                  <%} %>
                 <form method="post" action="${context}/login?page=login">          
                    <div class="form_row">
                    <label class="contact"><strong>Email:</strong></label>
                    <input type="text" class="contact_input" required="required" name="email"/>
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>Password:</strong></label>
                    <input type="password" class="contact_input" required="required" name="pass" />
                    </div>                     

                 <!--    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        Remember me
                        </div>
                    </div>  -->

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="login" />
                    </div>   
                    
                  </form>     
                    
                </div>  
            
            </div>	
            
              

            

            
        <div class="clear"></div>
        </div><!--end of left content-->



 		<%@ include file="../includes/right.jsp" %>

       
       <div class="clear"></div>
       <!--end of center content-->
        


        <%@ include file="../includes/footer.jsp" %>
        
 
</body>


</html>