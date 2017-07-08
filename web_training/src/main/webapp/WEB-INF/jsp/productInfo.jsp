<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/7/2
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">

    function submitInfo(id) {
        var inputs = new Array();
        inputs.push(id);
        $.ajax({
            async:false,
            url:'/queryOrderInfo',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            success: function() {
               // alert("success");
                window.location.href="/confirm";
            },
            error:function () {
               // alert("error");
                window.location.href="/login";
            }
        });
        //location.reload(true);
    }


    function addCart(id) {
        var inputs = new Array();
        inputs.push(id);
        $.ajax({
            async:false,
            url:'/addCart',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                alert("success");
                window.location.href="/queryAllProducts";
            },
            error:function () {
                // alert("error");
                window.location.href="/login";
            }
        });
    }

</script>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <%--<div id="logo"><img src="images/logo.gif" /></div>--%>
    <div class="help"><a href="shopping.html" class="shopping">购物车</a><a href="../../loginUi">登录</a><a href="../../loginOut">登出</a></div>
    <div class="navbar">
        <%--<ul class="clearfix">--%>
            <%--<li class="current"><a href="#">首页</a></li>--%>
            <%--<li><a href="#">图书</a></li>--%>
            <%--<li><a href="#">百货</a></li>--%>
            <%--<li><a href="#">品牌</a></li>--%>
            <%--<li><a href="#">促销</a></li>--%>
        <%--</ul>--%>
    </div>
</div>
<div id="childNav">
    <div class="wrap">
    </div>
</div>
<div id="main" class="wrap">
    <%--<div class="lefter">--%>
        <%--&lt;%&ndash;<div class="box">&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;<h2>商品分类</h2>&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;<dl>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dt>图书音像</dt>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">图书</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">音乐</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dt>百货</dt>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">运动健康</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">服装</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">家居</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">美妆</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">母婴</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">食品</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">手机数码</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">家具首饰</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">手表饰品</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">鞋包</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">家电</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">电脑办公</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">玩具文具</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;&lt;%&ndash;<dd><a href="product-list.html">汽车用品</a></dd>&ndash;%&gt;&ndash;%&gt;--%>
            <%--&lt;%&ndash;&lt;%&ndash;</dl>&ndash;%&gt;&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--</div>--%>
    <div id="product" class="main">
        <h1>${product.productName}</h1>
        <div class="infos">
            <div class="thumb"><img src="${product.picture}" width="110" height="106" /></div>
            <div class="buy">
                商城价：<span class="price">￥${product.price}</span><br />
                库　存：${product.productCount}
                <div class="button"><input type="button" name="button" value="立即购买" onclick="submitInfo(${product.id})" />
                    <input type="button" name="button" value="加入购物车" onclick="addCart(${product.id})" />
                   </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="introduce">
            <h2><strong>商品详情</strong></h2>
            <div class="text">
                ${product.detail}<br />
                <br />
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>

