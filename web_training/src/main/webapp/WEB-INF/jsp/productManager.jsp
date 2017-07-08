<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/6/30
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!-- jstl标签核心库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">

    function changeProduct(id) {
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
                window.location.href="/productModify";
            },
            error:function () {
                alert("error");
            }
        });
     //  location.reload(true);
    }

    function deleteProduct(id) {
        var inputs = new Array();
        inputs.push(id);
        $.ajax({
            async:false,
            url:'/deleteProduct',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                alert("success");
//               window.location.href="/productModify";
                location.reload(true);
            },
            error:function () {
                alert("error");
            }
        });

    }

</script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div class="help"><a href="../../loginOut">登出</a></div>
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
    <div id="menu-mng" class="lefter">
        <%--<div class="box">--%>
            <%--<dl>--%>
                <%--<dt>用户管理</dt>--%>
                <%--<dd><a href="user.html">用户管理</a></dd>--%>
                <%--<dt>商品信息</dt>--%>
                <%--<dd><em><a href="productClass-add.html">新增</a></em><a href="productClass.html">分类管理</a></dd>--%>
                <%--<dd><em><a href="product-add.html">新增</a></em><a href="product.html">商品管理</a></dd>--%>
                <%--<dt>订单管理</dt>--%>
                <%--<dd><a href="order.html">订单管理</a></dd>--%>
                <%--<dt>留言管理</dt>--%>
                <%--<dd><a href="guestbook.html">留言管理</a></dd>--%>
                <%--<dt>新闻管理</dt>--%>
                <%--<dd><em><a href="news-add.html">新增</a></em><a href="news.html">新闻管理</a></dd>--%>
            <%--</dl>--%>
        <%--</div>--%>
    </div>
    <div class="main">
        <h2>商品管理</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th>编号</th>
                    <th>商品名称</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td class="first w4 c" >${product.id}</td>
                        <td class="thumb">${product.productName}</td>
                        <td class="w1 c"><a  onclick="changeProduct(${product.id})">修改</a> <a class="manageDel" onclick="deleteProduct(${product.id})">删除</a></td>
                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>
    <div class="clear"></div>
    <%--<div class="pager">--%>
        <%--<ul class="clearfix">--%>
            <%--<li><a >首页</a></li>--%>
            <%--<li>...</li>--%>
            <%--<li><a >4</a></li>--%>
            <%--<li class="current">5</li>--%>
            <%--<li><a >6</a></li>--%>
            <%--<li>...</li>--%>
            <%--<li><a >尾页</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
</div>

</body>
</html>

