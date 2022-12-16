<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="MainController" method="post">
    <label for="email">Email</label>
    <input name="email" id="email" type="email" required/>
    <label for="password">Password</label>
    <input name="password" id="password" type="password" required/>
    <label for="username">Username</label>
    <input name="username" id="username" type="text" required/>
    <label for="phone">Phone</label>
    <input name="phone" id="phone" type="tel" required/>
    <button name="action" type="submit" value="Sign up">Sign up</button>
    <button name="action" type="reset">Reset</button>
</form>
<c:if test="${requestScope.ERROR != null && not empty requestScope.ERROR}">
    ${requestScope.ERROR}
</c:if>
</body>
</html>
