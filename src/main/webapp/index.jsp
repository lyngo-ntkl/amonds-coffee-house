<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Amonds Coffee House</title>
</head>
<body>
    <c:choose>
        <c:when test="${requestScope.PRODUCTS != null && not empty requestScope.PRODUCTS}">
            <c:set var="products" value="${requestScope .PRODUCTS}"/>
        </c:when>
        <c:otherwise>
            <c:set var="products" value="${applicationScope.PRODUCTS}"/>
        </c:otherwise>
    </c:choose>

    <div class="row">
    <c:forEach items="${products}" var="product" varStatus="count">
        <div class="col-lg-4 col-md-6">
            <form action="MainController" method="post">
                <c:if test="${product.productImages != null && not empty product.productImages}">
                    <img src="${product.productImages.iterator().next()}" alt="${product.productName}"/><br>
                </c:if>
                ${product.productName}<br>
                ${product.price}<br>
                <input type="hidden" name="productId" value="${product.productId}"/>
                <button type="submit" name="action" value="Add to cart" class="btn btn-outline-info">Add to cart</button>
            </form>
        </div>
    </c:forEach>
    </div>
</body>
</html>