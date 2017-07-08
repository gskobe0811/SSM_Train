<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="scripts/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
    function addNewUser() {

        var inputs = new Array();
        var in_username = document.getElementById("new_username");
        var n_username = in_username.value;
        var in_password1 = document.getElementById("new_password1");
        var n_password1 = in_password1.value;
        var in_password2 = document.getElementById("new_password2");
        var n_password2 = in_password2.value;

        inputs.push(n_username);
        inputs.push(n_password1);
        inputs.push(n_password2);

        if(n_username.length == 0){
            alert("用户名不能为空");
        }
        if(n_password1.length == 0){
            alert("密码不能为空");
        }


        $.ajax({
            async:false,
            url:'/addUser',
            type: 'POST',
            data: JSON.stringify(inputs),
            dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function(msg) {

            }
        });
        location.reload(true);
    }

    function deleteItem(id) {
        //var id_list = new Array();
        //var name_list = new Array();
        //var inputs= document.getElementsByTagName("input");
//        for(var i=0; i < inputs.length; i++){
//            if(inputs[i].type=='checkbox' && !inputs[i].disabled){
//                if(inputs[i].checked){
//                    id_list.push(parseInt(inputs[i].id));
//
//                    name_list.push(document.getElementById("ck_usr" + inputs[i].id).value);
//                }
//            }
//        }
//        if(id_list.length<1){
//            alert('未选中任何用户.');
//            return;
//        }

        if(!window.confirm("确认删除用户" + id +"吗?" )){
            return;
        }

        $.ajax({
            async:false,
            url:'/deleteItem',
            type: 'POST',
            data: JSON.stringify(id),
            //dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function(result) {
                alert(result);
                location.reload(true);
            }
        });

    }

    function updateUser(id) {


        var input_user = new Array();
        var username = document.getElementById("ck_usr" + id).value;
        var password = document.getElementById("ck_pwd" + id).value;

        input_user.push(username);
        input_user.push(password);
        input_user.push(id);

        if(username.length == 0){
            alert("更新的用户名不能为空");
        }
        if(password.length == 0){
            alert("更新的密码不能为空");
        }

        //alert(input_user);
        $.ajax({
            async:false,
            url:'/updateItem',
            type: 'POST',
            data: JSON.stringify(input_user),
            dataType: 'json',
            contentType:'application/json;charset=UTF-8',
            success: function(msg) {

            }
        });
        location.reload(true);

    }

</script>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css" />
    <script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../scripts/function.js"></script>
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

</div>
<div id="position" class="wrap">
    您现在的位置：<a >购物网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">

    </div>
    <div class="main">
        <h2>用户管理</h2>
        <div class="manage">
            <table class="list">
                <tr>
                    <th></th>
                    <th>类型</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>确认密码</th>
                    <th>操作</th>
                </tr>


                <c:forEach items="${userList}" var="user">
                    <tr align="center">
                        <form method="post" autocomplete="off">
                            <td><input type="checkbox"  id="${user.id}" onclick="deleteItem('${user.id}')" <c:if test="${user.userType !=3}">disabled="disabled"</c:if> /></td>
                            <td>用户</td>
                            <td><input style="text-align: center;" id ="ck_usr${user.id}"  name="m_username" value="${user.username}"/></td>
                            <td><input name="m_password1" id = "ck_pwd${user.id}"  /></td>
                            <td><input name="m_password2" /></td>
                            <td><input type="submit" onclick="updateUser(${user.id})"  value="更新"></td>

                            <td></td>
                        </form>
                    </tr>
                </c:forEach>


                <tr align="center">
                    <td></td>
                    <td>用户</td>
                    <td><input style="text-align: center;" id="new_username" autocomplete="off"/></td>
                    <td><input style="text-align: center;" id="new_password1" autocomplete="off"/></td>
                    <td><input style="text-align: center;" id="new_password2" autocomplete="off"/></td>
                    <td><button onclick="addNewUser()">添加用户</button></td>
                </tr>


            </table>
        </div>
    </div>
    <div class="clear"></div>
    <div class="pager">

    </div>
</div>

</body>
</html>











