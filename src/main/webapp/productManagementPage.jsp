<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
    <c:if test="${sessionScope.USER == null || sessionScope.USER.roleId ne 'AD'}">
        <c:redirect url="loginPage.jsp"/>
    </c:if>
    <c:choose>
        <c:when test="${requestScope.PRODUCTS != null && not empty requestScope.PRODUCTS}">
            <c:set var="products" value="${requestScope.PRODUCTS}"/>
        </c:when>
        <c:otherwise>
            <c:set var="products" value="${applicationScope.PRODUCTS}"/>
        </c:otherwise>
    </c:choose>

    <form action="MainController" method="POST" class="d-flex">
        <div class="input-group">
            <input type="search" name="key" value="${param.key}" class="form-control col-md-6" placeholder="Keyword">
            <select name="type" class="form-select form-select-lg">
                <option value="name">by name</option>
                <option value="category">by category</option>
            </select>
            <input type="submit" value="Search" name="action" class="btn btn-outline-success">
        </div>
    </form>

    <table class="table-primary table-striped table-hover">
        <thead>
            <tr>
                <th scope="col">No</th>
                <th scope="col">Product ID</th>
                <th scope="col">Product name</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Image</th>
                <th scope="col">Description</th>
                <th scope="col">Update</th>
                <th scope="col">Remove</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product" varStatus="count">
            <form method="post" action="MainController" enctype="multipart/form-data">
                <tr>
                    <td>${count.count}</td>
                    <td>${product.productId}
                        <input type="hidden" name="productId" value="${product.productId}"/>
                    </td>
                    <td>
                        <input type="text" name="productName" value="${product.productName}"/>
                    </td>
                    <td>
                        ${product.category.categoryName}
<%--                        <select name="category">--%>
<%--                            <c:forEach items="${applicationScope.CATEGORIES}" var="cate">--%>
<%--                                <option value="${cate.categoryId}"--%>
<%--                                        <c:if test="${cate.categoryId == product.category.categoryId}">selected</c:if>--%>
<%--                                >${cate.categoryName}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
                    </td>
                    <td>
                        <input type="number" name="price" step="any" value="${product.price}"/>
                    </td>
                    <td>
                        <input type="number" name="quantity" value="${product.quantity}" min="0"/>
                    </td>
                    <td>
                        <input type="file" name="imgPath" accept="image/jpeg, image/png"/>
                    </td>
                    <td>
                        <input type="text" name="description" value="${product.description}"/>
                    </td>
                    <td>
                        <input type="submit" value="Update" name="action" class="btn btn-outline-success"/>
                    </td>
                    <td>
                        <input type="submit" value="Remove" name="action" class="btn btn-outline-success"/>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
        </table>

</body>
</html>
