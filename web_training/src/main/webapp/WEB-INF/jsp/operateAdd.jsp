<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/6/29
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">

    var productName = document.getElementById("productName").value;
    function addProduct() {
        var inputs = new Array();
        //alert("商品名称" + productName);
        var product_describe = document.getElementById("product_describe").value;
        //alert("商品描述" + product_describe);
        var productType = $("select option:selected").text();
       // alert("商品类型" + productType);
        var product_price = document.getElementById("product_price").value;
        var productCount = document.getElementById("productCount").value;

       // var product_picture = document.getElementById("product_picture").value;

        inputs.push(productName);
        inputs.push(product_describe);
        inputs.push(productType);
        inputs.push(product_price);
        inputs.push(productCount);
      //  inputs.push(product_picture);

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
            url:'/addProduct',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                window.location.href="/productModify";
            }
        });
        location.reload(true);
    }

    function skipPicturePage() {

    }

    function addProductPicture(pic_url) {
        form = document.getElementById("productAdd");
        var formData = new FormData(form);
        $.ajax(
            {
                async: false,
                url: pic_url,
                type: "POST",
                data: formData,
                mimeType: "multipart/form-data",
                dataType:'json',
                contentType: false,
                cache: false,
                processData: false,
                success: function (result) {
//                    if(result.err!="")
//                        alert(result.err);
//                    if (result.stat == 'GOTO') {
//                        window.location.href = result.goto;
//                    } else {
//                        location.reload(true);
//                    }
                },
                error: function (result) {
//                    alert(result.err);
//                    result = $.parseJSON(result);
//                    alert(result.err + result.acc);
//                    alert('ERR.');
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
        <ul class="clearfix">
            <li><a href="index.html">首页</a></li>
            <li><a href="user.html">用户</a></li>
            <li class="current"><a href="product.html">商品</a></li>
            <li><a href="order.html">订单</a></li>
            <li><a href="guestbook.html">留言</a></li>
            <li><a href="news.html">新闻</a></li>
        </ul>
    </div>
</div>

<div id="childNav">

</div>

<div id="main" class="wrap">

    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>商品信息</dt>
                <dd><a href="../../managerProduct">商品管理</a></dd>
                <dt>订单管理</dt>
                <dd><a href="../../showAllOrders">订单管理</a></dd>
            </dl>
        </div>
    </div>


    <div class="main">
        <h2>添加商品</h2>
        <div class="manage">
            <%--<form id="productAdd" >--%>
                <%--<table class="form">--%>
                    <%--<tr>--%>
                        <%--<td class="field">商品名称(*)：</td>--%>
                        <%--<td><input type="text" class="text" name="productName" id = "productName" /><span></span></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="field">描述：</td>--%>
                        <%--<td><input type="text" class="text" name="productDetail" id = "product_describe"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                    <%--<td class="field" >所属分类：</td>--%>
                    <%--<td>--%>
                        <%--<select >--%>
                            <%--<option value="1" id = "type_1">电器</option>--%>
                            <%--<option value="2" id = "type_2">衣服</option>--%>
                            <%--<option value="2" id = "type_3">食品</option>--%>
                            <%--<option value="2" id = "type_4">书籍</option>--%>
                        <%--</select>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="field">商品价格(*)：</td>--%>
                        <%--<td><input type="text" class="text tiny" name="productPrice" id = "product_price"/> 元<span></span></td>--%>
                    <%--</tr>--%>

                    <%--<tr>--%>
                        <%--<td class="field">库存(*)：</td>--%>
                        <%--<td><input type="text" class="text tiny" name="productNumber" id = "productCount"/><span></span></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="field">商品图片(*)：</td>--%>
                        <%--<td><input type="text" class="text" name="file" id = "product_picture"--%>
                                <%--onclick="skipPicturePage()"--%>
                        <%--/><span></span></td>--%>

                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td></td>--%>
                        <%--<td><label class="ui-blue"><input type="submit" onclick="addProduct()" name="submit" value="确定" /></label></td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</form>--%>




            <form id="productAdd" method="post" enctype="multipart/form-data" action="/productUpload">
                <table class="form">
                    <tr>
                        <td class="field">商品名称(*)：</td>
                        <td><input type="text" class="text" name="productName" id = "productName" />请输入商品名</td>
                    </tr>
                    <tr>
                        <td class="field">描述：</td>
                        <td><input type="text" class="text" name="detail" id = "detail"/>请输入描述</td>
                    </tr>
                    <tr>
                        <td class="field" >所属分类：</td>
                        <td><input type="text" class="text" name="productType" id = "productType"/>请输入描述</td>
                        <%--<td>--%>
                            <%--<select >--%>
                                <%--<option value="1" id = "type_1">电器</option>--%>
                                <%--<option value="2" id = "type_2">衣服</option>--%>
                                <%--<option value="2" id = "type_3">食品</option>--%>
                                <%--<option value="2" id = "type_4">书籍</option>--%>
                            <%--</select>--%>
                        <%--</td>--%>
                    </tr>
                    <tr>
                        <td class="field">商品价格(*)：</td>
                        <td><input type="text" class="text tiny" name="price" id = "product_price"/> 元<span></span></td>
                    </tr>

                    <tr>
                        <td class="field">库存(*)：</td>
                        <td><input type="text" class="text tiny" name="productCount" id = "productCount"/><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">商品图片(*)：</td>
                        <td><input type="file" class="text" name="file" id = "picture"
                        /><span></span></td>

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

