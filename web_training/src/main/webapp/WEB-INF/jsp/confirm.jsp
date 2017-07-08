<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/7/2
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
    function submitOrderInfo() {
        var inputs = new Array();

        var productName = document.getElementById("productName").value;
      //  alert("商品名 " + productName);
        var productPrice = document.getElementById("productPrice").value;
      // alert("单价" + productPrice);
        var buyer = document.getElementById("productBuyer").value;
       // alert("收货人" + buyer);
        var mobile = document.getElementById("telPhone").value;
      //  alert("电话" + mobile);
        var address = document.getElementById("address").value;
      //  alert("地址" + address);
        var number = document.getElementById("number").value;
      //  alert("购买数量" + number);


        inputs.push(productName);
        inputs.push(productPrice);
        inputs.push(buyer);
        inputs.push(mobile);
        inputs.push(address);
        inputs.push(number);

        $.ajax({
            async:false,
            url:'/submitOrderInfo',
            type: 'POST',
            data: JSON.stringify(inputs),
            // dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function() {

                window.location.href="/queryAllProducts";

            },error:function () {

            }
        });

    }

</script>



<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理 - 易买网</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">

    <div class="help"><a href="../../queryAllProducts">返回首页</a></div>
</div>
<div id="childNav">
</div>
<div id="position" class="wrap">
</div>
<div id="main" class="wrap">
    <div class="main">
        <h2>订单详情</h2>
        <div class="manage">
            <form action="manage-result.html">
                <table class="form">

                    <tr>
                        <td class="field">商品名：</td>
                        <td><input type="text" class="text" name="productName" id = "productName" value="${orderDetail.proName}" readonly="readonly" /></td>
                    </tr>

                    <tr>
                        <td class="field">单价：</td>
                        <td><input type="text" class="text" name="productPrice" id = "productPrice" value="${orderDetail.proPrice}" readonly="readonly" /></td>
                    </tr>

                    <tr>
                        <td class="field">收货人：</td>
                        <td><input type="text" class="text" name="buyer" id = "productBuyer" value="${orderDetail.buyer}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td class="field">收货人电话：</td>
                        <td><input type="text" class="text" name="mobile" id = "telPhone" value="${orderDetail.telPhone}" /></td>
                    </tr>
                    <tr>
                        <td class="field" >收货人地址：</td>
                        <td><input type="text" class="text" name="address" id = "address" value="${orderDetail.adderss}" /></td>

                    </tr>
                    <tr>
                        <td class="field">数量：</td>
                        <td><input type="text" class="text" name="number" id = "number" value="${orderDetail.count}" /></td>

                    </tr>

                    <tr>
                        <td></td><td><label class="ui-blue"><input  name="submit" value="确认" onclick="submitOrderInfo()"/></label></td>
                    </tr>


                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>


