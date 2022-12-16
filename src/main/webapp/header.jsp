<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="icon" href="image/AmondsCoffeeHouseLogo1.png">
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="script" href="bootstrap-5.0.2-dist/js/bootstrap.bundle.min.js">
<%--    <link rel="stylesheet" href="scss/stylesheet.css">--%>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a href="" class="navbar-brand"><img style="width: 50px" src="image/AmondsCoffeeHouseLogo1.png" alt="amonds coffee house logo"></a>
            <div class="collapse navbar-collapse">
                <c:if test="${sessionScope.USER == null || sessionScope.USER.roleId ne 'AD'}">
                    <form action="MainController" method="POST" class="d-flex col-md-5">
                        <div class="input-group">
                            <input type="search" name="key" value="${param.key}" class="form-control" placeholder="Keyword">
                            <select name="type" class="form-select form-select-lg">
                                <option value="name">by name</option>
                                <option value="category">by category</option>
                            </select>
                            <input type="submit" value="Search" name="action" class="btn btn-outline-success">
                        </div>
                    </form>
                </c:if>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a href="
                        <c:choose>
                            <c:when test="${sessionScope.USER != null && sessionScope.USER.roleId eq 'AD'}">adminIndex.jsp</c:when>
                            <c:otherwise>index.jsp</c:otherwise>
                        </c:choose>
                        " class="nav-link">Home</a>
                    </li>

                    <li class="nav-item"><a href="cart.jsp" class="nav-link">Cart</a></li>

                    <c:if test="${sessionScope.USER != null && sessionScope.USER.roleId eq 'US'}">
                        <li class="nav-item"><a href="orderHistory.jsp" class="nav-link">Order history</a></li>
                    </c:if>

                    <c:if test="${sessionScope.USER == null}">
                        <li class="nav-item"><a href="registrationPage.jsp" class="nav-link">Register</a></li>
                        <li class="nav-item"><a href="loginPage.jsp" class="nav-link">Login</a></li>
                    </c:if>

                    <c:if test="${sessionScope.USER != null && sessionScope.USER.roleId eq 'AD'}">
                        <li class="nav-item"><a href="MainController?action=View Accounts" class="nav-link">Manage
                            accounts</a></li>
                        <li class="nav-item"><a href="productManagementPage.jsp" class="nav-link">Manage
                            products</a></li>
                    </c:if>

                    <c:if test="${sessionScope.USER != null && not empty sessionScope.USER}">
                        <!-- Example single danger button -->
                        <div class="btn-group">
                            <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                Action
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="MainController?action=Logout">Logout</a></li>
                            </ul>
                        </div>
                    </c:if>
                </ul>


            </div>
        </div>
    </nav>
</header>
</body>
</html>
