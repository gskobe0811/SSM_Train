<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/7/3
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
    function submitUserInfo() {
        var inputs = new Array();

        var username = document.getElementById("username").value;
        alert("用户名 " + username);
        var password = document.getElementById("password").value;
        alert("密码" + password);
        var address = document.getElementById("address").value;
        alert("地址" + address);
        var mobile = document.getElementById("mobile").value;
        alert("电话" + mobile);
        var userId = document.getElementById("userId").value;
        alert("用户id" + userId);

        inputs.push(username);
        inputs.push(password);
        inputs.push(address);
        inputs.push(mobile);
        inputs.push(userId);

        $.ajax({
            async:false,
            url:'/submitUserInfo',
            type: 'POST',
            data: JSON.stringify(inputs),
            // dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function() {
                alert("修改成功");
                window.location.href="/queryAllProducts";
                // window.location.href=document.referrer;
                //history.go(-1);
            },error:function () {
                alert("请求失败");
            }
        });
       // location.reload(true);
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
    <div class="help"><a href="../../queryAllProducts">返回首页</a></div>
</div>
<div id="childNav">
</div>
<div id="position" class="wrap">
</div>
<div id="main" class="wrap">
    <div class="main">
        <h2>个人中心</h2>
        <div class="manage">
            <form >
                <table class="form">

                    <tr>
                        <td class="field">用户编号：</td>
                        <td><input type="text" class="text" name="userId" id = "userId" value="${user.id}" disabled = "disabled"/></td>
                    </tr>

                    <tr>
                        <td class="field">用户名：</td>
                        <td><input type="text" class="text" name="username" id = "username" value="${user.username}" /></td>
                    </tr>

                    <tr>
                        <td class="field">密码：</td>
                        <td><input type="text" class="text" name="password" id = "password" value="" /></td>
                    </tr>

                    <tr>
                        <td class="field">地址：</td>
                        <td><input type="text" class="text" name="address" id = "address" value="${user.address}"  /></td>
                    </tr>

                    <tr>
                        <td class="field">电话：</td>
                        <td><input type="text" class="text" name="mobile" id = "mobile" value="${user.telPhone}" /></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><label class="ui-blue"><input  name="submit" value="确认" onclick="submitUserInfo()"/></label></td>
                    </tr>

                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>
</body>
</html>



