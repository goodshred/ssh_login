<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'update_save.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

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
        String sql = "update user set username=?,password=?,email=?where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        pstmt.setString(3,email);
        pstmt.setInt(4,Integer.parseInt(request.getParameter("id")));

        pstmt.executeUpdate();
        pstmt.close();
    }catch(Exception e){
        out.println(e);
    }finally{

    }
    response.sendRedirect("student_info.jsp");

%>
</body>
</html>
