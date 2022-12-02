<html>
<head>
    <link rel="icon" href="image/AmondsCoffeeHouseLogo1.png">
    <link href="bootstrap-5.0.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="scss/stylesheet.css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a href="" class="navbar-brand"><img style="width: 50px" src="image/AmondsCoffeeHouseLogo1.png" class="lo"></a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        
                        <a href="
                                   <c:choose>
                                       <c:when test="${sessionScope.LOGIN_USER != null && sessionScope.LOGIN_USER.role == 1}">
                                           adminIndex.jsp
                                       </c:when>
                                       <c:when test="${sessionScope.LOGIN_USER != null && sessionScope.LOGIN_USER.role == 0}">
                                           userIndex.jsp
                                       </c:when>
                                       <c:otherwise>
                                           index.jsp
                                       </c:otherwise>
                                   </c:choose>" class="nav-link">Home
                        </a>
                    </li>


                    <c:if test="${sessionScope.LOGIN_USER == null}">
                        <li class="nav-item"><a href="registration.jsp" class="nav-link">Register</a></li>
                        <li class="nav-item"><a href="login.jsp" class="nav-link">Login</a></li>
                    </c:if>

                    <c:if test="${sessionScope.LOGIN_USER != null && not empty sessionScope.LOGIN_USER}">
                        <c:if test="${sessionScope.LOGIN_USER.role == 0}">
                            <li class="nav-item"><a href="cart.jsp" class="nav-link">Cart</a></li>
                            <li class="nav-item"><a href="orderHistory.jsp" class="nav-link">Order history</a></li>
                        </c:if>
                        <c:if test="${sessionScope.LOGIN_USER.role == 1}">
                            <li class="nav-item"><a href="MainController?action=View Accounts" class="nav-link">Manage accounts</a></li>
                        </c:if>
                        <li class="nav-item"><a href="MainController?action=Logout" class="nav-link">Logout</a></li>
                    </c:if>
                </ul>
                <form action="MainController" method="POST" class="d-flex">
                    <input type="search" name="key" value="${param.key}" class="form-control" placeholder="Keyword">
                    <select name="type" class="form-select form-select-lg">
                        <option value="name">by name</option>
                        <option value="category"
                                <c:if test="${param.type == 'category'}">selected=""</c:if>>by category</option>
                    </select>
                    <input type="submit" value="Search" name="action" class="btn btn-outline-success">
                </form>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
