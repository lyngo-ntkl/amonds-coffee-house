<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="MainController">
    <div class="mb-3 row">
      <label for="email" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-10">
        <input name="email" type="email" class="form-control" id="email" placeholder="email@example.com">
      </div>
    </div>
    <div class="mb-3 row">
      <label for="password" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-10">
        <input name="password" type="password" class="form-control" id="password">
      </div>
    </div>
    <div class="mb-3 row">
      <button value="Login" name="action" type="submit" class="btn btn-primary">Login</button>
    </div>
  </form>
  <c:if test="${requestScope.ERROR != null && not empty requestScope.ERROR}">
      ${ERROR}
  </c:if>
</body>
</html>
