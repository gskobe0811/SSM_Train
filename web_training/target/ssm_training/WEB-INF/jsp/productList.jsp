<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/6/27
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!-- jstl标签核心库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">

    function productInfo(id) {
        var inputs = new Array();
        inputs.push(id);
        $.ajax({
            async:false,
            url:'/changeProduct',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                //alert("success");

                window.location.href="/productInfo";
            },
            error:function () {
                alert("error");
            }
        });
        //  location.reload(true);
    }

</script>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>招行购物网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>


<div id="header" class="wrap">
    <div class="help"><a href="../../queryCarts" >购物车</a><a href="../../loginUi">登录</a>
        <a href="../../changeUserInfo">个人中心</a> <a href="../../myOrders">我的订单</a></div>
</div>


<div id="main" class="wrap">
    <div class="lefter">


    </div>
    <div class="main">
        <div class="price-off">

            <h2>商品列表</h2>
            <ul class="product clearfix">
                <c:forEach items="${allProducts}" var="product">
                <li>
                    <dl>
                        <dt><a onclick="productInfo(${product.id})" target="_self"><img src="${product.picture}" /></a></dt>
                        <dd class="title"><a  onclick="productInfo(${product.id})" target="_self">${product.detail}</a></dd>
                        <dd class="price">￥${product.price}</dd>
                    </dl>
                </li>
            </c:forEach>
            </ul>
        </div>

        <div class="spacer clear"></div>
    </div>
</div>
</body>
</html>





