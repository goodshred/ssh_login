<%--
  Created by IntelliJ IDEA.
  User: lmj
  Date: 2019/3/27
  Time: 7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    request.setCharacterEncoding("utf8");

    Cookie[] loginCookie =request.getCookies();
    if (loginCookie!=null){
        for (Cookie cookie:loginCookie){
            if (cookie.getName().equals("username")){
               cookie.setValue("");
               response.addCookie(cookie);
            }
            if (cookie.getName().equals("password")){
                cookie.setValue("");
                response.addCookie(cookie);
            }
        }
    }
%>
<body>

<%
HttpSession session1=request.getSession();
session1.invalidate();
//System.out.println(session1.getAttribute("username")+"?????????????????????????????");
response.sendRedirect("/login.jsp");
%>
</body>
</html>
