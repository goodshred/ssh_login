<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: lmj
  Date: 2019/4/3
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");

    String username=request.getParameter("name");
    String password=request.getParameter("password");
    String email=request.getParameter("email");

    final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    final String DBURL = "jdbc:mysql://127.0.0.1:3306/javaweb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    final String DBUSER = "root";
    final String DBPASS = "root";

    Connection conn = null;
    try{
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        String sql = "insert into user(username,password,email) values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,username);
        pstmt.setString(2,password);
        pstmt.setString(3,email);


        pstmt.executeUpdate();
        pstmt.close();
    }catch(Exception e){
        System.out.println(e.toString());
    }finally{

    }
    response.sendRedirect("student_info.jsp");

%>
</body>
</html>
