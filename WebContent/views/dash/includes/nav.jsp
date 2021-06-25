
   <div class="dash-nav dash-nav-dark">
            <header>
                <a href="#!" class="menu-toggle">
                    <i class="fas fa-bars"></i>
                </a>
                <a href="${pageContext.request.contextPath}/" class="easion-logo" ><img class="imglogo" src="${pageContext.request.contextPath}/views/images/logo.gif"/></a>
            </header>
            <nav class="dash-nav-list">
                <a href="${pageContext.request.contextPath}/Admin?page=index" class="dash-nav-item">
                    <i class="fas fa-home"></i> Dashboard </a>
               
                    <a href="${pageContext.request.contextPath}/Admin?page=listproduct" class="dash-nav-item ">
                        <i class="fas fa-chart-bar"></i> Products </a>
       
                    <a href="${pageContext.request.contextPath}/Admin?page=listcategory" class="dash-nav-item ">
                        <i class="fas fa-cube"></i> Categorys </a>
                        <a href="${pageContext.request.contextPath}/Admin?page=listclient" class="dash-nav-item ">
                        <i class="fas fa-cube"></i>List Clients </a>
              
          
            </nav>
        </div>
      
         <div class="dash-app">
                  <header class="dash-toolbar">
                <a href="#!" class="menu-toggle">
                    <i class="fas fa-bars"></i>
                </a>
               
                <div class="tools">
                  
                    <div class="dropdown tools-item">
                        <a href="#" class="" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                         <a class="dropdown-item" href="${pageContext.request.contextPath}/login?page=deconect">Deconnecter</a>
                        </div>
                    </div>
                </div>
            </header>
