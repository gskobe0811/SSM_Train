<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/7/5
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">


    function deleteItem(id) {

        $.ajax({
            async:false,
            url:'/deleteCartItem',
            type: 'POST',
            data: JSON.stringify(id),
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                alert("success");

                location.reload(true);
            },
            error:function () {
                alert("error");

            }
        });

    }


    function submitOrders() {

        var inputs = document.getElementsByName("cart_id");
        var arr = new Array();
        for(var i = 0; i<inputs.length; i++){
            arr.push(inputs[i].value);
        }
        $.ajax({
            async:false,
            url:'/submitOrder',
            type: 'POST',
            data: JSON.stringify(arr),
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                alert("success");

                window.location.href="/queryAllProducts";

            },
            error:function () {
                alert("error");

            }
        });

    }

</script>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>购物网</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>


<div id="header" class="wrap">

    <div class="help"><a href="../../queryAllProducts">返回前台页面</a>
        <a href="../../loginOut">登出</a>
    </div>
    <div class="navbar">

    </div>
</div>


<div id="childNav">
    <div class="wrap">

    </div>
</div>
<div id="position" class="wrap">

</div>
<div class="wrap">
    <div id="shopping">
        <form action="address.html">
            <table>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>购买数量</th>
                    <th>操作</th>
                </tr>

               <c:forEach items="${allCarts}" var="carts">

                <tr id="product_id_0">
                    <td class="thumb"><a>${carts.proName}</a></td>
                    <td class="price" id="price_id_0">
                        <span>￥${carts.proPrice}</span>
                        <input type="hidden" value="99" />
                    </td>
                    <td class="number">

                        <input type="text" id = "count" value="1">
                    </td>
                    <td class="delete"><a onclick="deleteItem(${carts.id})">删除</a></td>
                </tr>

                   <input type="hidden" value="${carts.id}" name = "cart_id"/>

               </c:forEach>

            </table>


            <div class="button"><input type="button" value="结 算" onclick="submitOrders()"/></div>
        </form>
    </div>

</div>

</body>
</html>

