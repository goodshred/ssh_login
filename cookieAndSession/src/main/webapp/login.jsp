<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>登录页面</title>
    <style type="text/css">
        .dv_error {
            color: red;
        }
    </style>
</head>
<body>
<form action="/myday13_zhuangtaiguanli/keeploginservlet" method="post">
    <label>账号：</label><input type="text" id="username" name="username"><br />
    <label>密码：</label><input type="password" id="password" name="password"><br />
    <label>密码：</label><input type="text" id="code" name="code"><img id="img1" src="/myday13_zhuangtaiguanli/vcodeservlet" onclick="changeImg()" /><a href="javascript:void(0)" onclick="changeImg()">看不清换一张</a><br />
    <input type="button" onclick="check()" value="登录">
    <label><a href="/myday13_zhuangtaiguanli/dindcookieservlet" >已经登陆，直接登陆</a></label>
</form>
<script type="text/javascript">
    function check(){
        var username = document.getElementById("username")
        var password = document.getElementById("password")
        var code = document.getElementById("code")
        if(username.value == ""){
            alert("请输入用户名")
        }else if(password.value == ""){
            alert("请输入密码")
        }else if(code.value == ""){
            alert("请输入验证码");
        }else{
            document.forms[0].submit()
        }
    }
    function changeImg(){
        var img1 = document.getElementById("img1")
        img1.src="/myday13_zhuangtaiguanli/vcodeservlet?num"+Math.random();
    }
</script>
</body>
</html>