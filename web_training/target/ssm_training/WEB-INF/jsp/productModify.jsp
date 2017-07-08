<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/6/30
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!-- jstl标签核心库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
    function submitProduct() {
        var inputs = new Array();

        var productId = document.getElementById("productId").value;
        alert("商品Id " + productId);
        var productName = document.getElementById("productName").value;
        //alert("商品名称" + productName);
        var product_describe = document.getElementById("product_describe").value;
        //alert("商品描述" + product_describe);
        var productType = $("select option:selected").text();
        // alert("商品类型" + productType);
        var product_price = document.getElementById("product_price").value;
        var productCount = document.getElementById("productCount").value;

        inputs.push(productId);
        inputs.push(productName);
        inputs.push(product_describe);
        inputs.push(productType);
        inputs.push(product_price);
        inputs.push(productCount);

        if(productName.length == 0){
            alert("商品名称不能为空");
        }
        if(product_price.length == 0){
            alert("商品价格不能为空");
        }
        if(productCount.length == 0){
            alert("商品库存不能为空");
        }
        if(productType.length == 0){
            alert("商品类型不能为空");
        }

        $.ajax({
            async:false,
            url:'/submitModify',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function(msg) {
                alert("修改成功");
                //window.location.href="/productManager";
               // window.location.href=document.referrer;
                history.go(-1);
            },error:function () {
                alert("请求失败");
            }
        });
        location.reload(true);
    }

</script>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">

    <div class="help"><a href="../../loginOut">登出</a></div>
    <%--<div class="navbar">--%>
        <%--<ul class="clearfix">--%>
            <%--<li><a href="index.html">首页</a></li>--%>
            <%--<li><a href="user.html">用户</a></li>--%>
            <%--<li class="current"><a href="product.html">商品</a></li>--%>
            <%--<li><a href="order.html">订单</a></li>--%>
            <%--<li><a href="guestbook.html">留言</a></li>--%>
            <%--<li><a href="news.html">新闻</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
</div>
<div id="childNav">
    <div class="welcome wrap">

    </div>
</div>
<div id="position" class="wrap">

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
        <h2>修改商品</h2>
        <div class="manage">




                <form id="modify" method="post" enctype="multipart/form-data" action="/submitModify">
                    <table class="form">

                        <tr>
                        <td class="field">商品id(*)：</td>
                        <td><input type="text" class="text" name="id" value="${product.id}" id = "productId" readonly="readonly"/></td>
                        </tr>

                        <tr>
                        <td class="field">商品名称(*)：</td>
                        <td><input type="text" class="text" name="productName" value="${product.productName}" id = "productName"/></td>
                        </tr>


                        <tr>
                        <td class="field">描述：</td>
                        <td><input type="text" class="text" name="detail" value="${product.detail}" id = "product_describe"/></td>
                        </tr>


                        <tr>
                        <td class="field">所属分类：</td>
                            <td><input type="text" class="text" name="productType" value="${product.productType}" id = "productType"/></td>

                        </tr>


                        <tr>
                        <td class="field">商品价格(*)：</td>
                        <td><input type="text" class="text tiny" name="price" value="${product.price}" id = "product_price"/> 元</td>
                        </tr>

                        <tr>
                        <td class="field">库存(*)：</td>
                        <td><input type="text" class="text tiny" name="productCount" value="${product.productCount}" id = "productCount"/></td>
                        </tr>
                        <tr>
                        <td class="field">商品图片：</td>
                        <td><input type="file" class="text" name="file" id = "product_picture"/></td>
                        </tr>
                        <tr>
                        <td></td>
                        <td><label class="ui-blue"><input type="submit"  name="submit" value="确定" /></label></td>
                        </tr>



                    </table>
                </form>


        </div>
    </div>


    <div class="clear"></div>

</div>

</body>

</html>


