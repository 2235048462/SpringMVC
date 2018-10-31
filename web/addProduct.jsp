<%--
  Created by IntelliJ IDEA.
  User: ChenBo
  Date: 2018/10/24
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--设计数据输入框--%>
<form action="addProduct" method="post">
    产品名称:<input type="text" name="productName" value=""><br/>
    产品价格:<input type="text" name="productPrice" value=""><br/>
    <input type="submit" value="增加商品">
</form>

