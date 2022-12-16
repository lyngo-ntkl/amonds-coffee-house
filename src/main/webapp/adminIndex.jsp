<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Administrator page</title>
</head>
<body>
    <c:if test="${sessionScope.USER == null || sessionScope.USER.roleId ne 'AD'}">
        <c:redirect url="index.jsp"/>
    </c:if>
    <h1>Welcome ${sessionScope.USER.username}</h1>
</body>
</html>
