<%--
  Created by IntelliJ IDEA.
  User: lmj
  Date: 2019/4/2
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Lowin</title>
    <link rel="stylesheet" href="css/auth.css">
    <script type="text/javascript">
        function validate(f) {
            if(f.name.value==null|f.name.value==""){
                alert("请输入用户名")
                f.name.focus();
                return false;
            }
            if(f.password.value==null|f.password.value==""){
                alert("请输入密码")
                f.password.focus();
                return false;
            }
            if(f.repassword.value!=f.password.value){
                alert("两次密码不一致")
                f.repassword.focus();
                return false;
            }
            return true;

        }
    </script>
</head>

<body>
<div class="lowin">
    <div class="lowin-brand">
        <img src="img/kodinger.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form method="post">
                    <p>登录以继续</p>
                    <div class="lowin-group">
                        <label>邮箱 <a href="#" class="login-back-link">登陆?</a></label>
                        <input type="email" autocomplete="email" name="email" class="lowin-input">
                    </div>
                    <div class="lowin-group password-group">
                        <label>密码 <a href="#" class="forgot-link">忘记密码?</a></label>
                        <input type="password" name="password" autocomplete="current-password" class="lowin-input">
                    </div>
                 <%--   <????????????????????????????????>--%>
                   <button class="lowin-btn login-btn">
                        登陆
                    </button>

                    <div class="text-foot">
                        没有账户? <a href="" class="register-link">注册</a>
                    </div>
                </form>
            </div>
        </div>

        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <form action="add.jsp" method="post" onsubmit="return validate(this)">
                    <p>让我们创建您的帐户</p>
                    <div class="lowin-group">
                        <label>名字</label>
                        <input type="text" name="name" autocomplete="name" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <label>邮箱</label>
                        <input type="email" autocomplete="email" name="email" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <label>密码</label>
                        <input type="password" name="password" autocomplete="current-password" class="lowin-input">
                    </div>
                    <div class="lowin-group">
                        <label>确认密码</label>
                        <input type="password" name="repassword" autocomplete="current-password" class="lowin-input">
                    </div>
                     <button class="lowin-btn" type="submit">
                        注册
                    </button>

                    <div class="text-foot">
                        已经有账户了? <a href="dosurvey.jsp" class="login-link">登陆</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <footer class="lowin-footer">

    </footer>
</div>

<script src="js/auth.js"></script>
<script>
    //login_url: '#login',
    Auth.init({
        login_url: 'login.jsp',
        forgot_url: '#forgot'
    });
</script>

</body>
</html>
