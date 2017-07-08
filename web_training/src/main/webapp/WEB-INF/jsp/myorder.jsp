<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/7/4
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!-- jstl标签核心库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>订单管理</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div class="help"><a href="../../loginOut">登出</a><a href="../../queryAllProducts">返回首页</a></div>
    <div class="navbar">
        <%--<ul class="clearfix">--%>
            <%--<li><a href="index.html">首页</a></li>--%>
            <%--<li><a href="user.html">用户</a></li>--%>
            <%--<li class="current"><a href="product.html">商品</a></li>--%>
            <%--<li><a href="order.html">订单</a></li>--%>
            <%--<li><a href="guestbook.html">留言</a></li>--%>
            <%--<li><a href="news.html">新闻</a></li>--%>
        <%--</ul>--%>
    </div>
</div>
<div id="childNav">
</div>

<div id="main" class="wrap">

    <div class="main">
        <h2>我的订单</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th>商品名称</th>
                    <th>数量</th>
                    <th>价格</th>
                    <th>状态</th>
                </tr>



                <c:forEach items="${myOrders}" var="order">
                    <tr>
                        <td class="thumb"><a href="../queryAllProducts" target="_self">${order.proName}</a></td>
                        <td class="first w4 c">${order.proCount}</td>
                        <td class="first w4 c">${order.orderPrice}</td>
                        <td class="first w4 c">${order.state}</td>
                    </tr>
                </c:forEach>


            </table>
        </div>
    </div>

</div>

</body>
</html>

