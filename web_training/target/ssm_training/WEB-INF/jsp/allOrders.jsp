<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
    function confirmOrder(id) {
        var inputs = new Array();
        inputs.push(id);
        $.ajax({
            async:false,
            url:'/confirmOrder',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                alert("success");
                //window.location.href="/confirm";
            },
            error:function () {
                alert("error");
                //window.location.href="/login";
            }
        });
        location.reload(true);
    }

    function refuseOrder(id) {
        var inputs = new Array();
        inputs.push(id);
        $.ajax({
            async:false,
            url:'/refuseOrder',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'text',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                alert("success");
                //window.location.href="/confirm";
            },
            error:function () {
                alert("error");
                //window.location.href="/login";
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
    <div class="navbar">

    </div>
</div>
<div id="childNav">

</div>

<div id="main" class="wrap">




    <div class="main">
        <h2>用户订单</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th>订单编号</th>
                    <th>买家</th>
                    <th>商品名</th>
                    <th>价格</th>
                    <th>状态</th>
                    <th></th>
                </tr>
                <c:forEach items="${allOrders}" var="order">
                <tr>

                        <td class="thumb">${order.id}</td>
                        <td class="first w4 c">${order.username}</td>
                        <td class="first w4 c">${order.proName}</td>
                        <td class="first w4 c">${order.orderPrice}</td>
                        <td class="first w4 c"><button type="button" onclick="confirmOrder(${order.id})">确认订单</button></td>
                        <td class="first w4 c"><button type="button" onclick="refuseOrder(${order.id})">拒绝订单</button></td>

                </tr>
                </c:forEach>

            </table>
        </div>
    </div>


</div>

</body>
</html>

