<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'delete.jsp' starting page</title>

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
    // int student_id = Integer.parseInt(request.getParameter("id"));
    final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    final String DBURL = "jdbc:mysql://127.0.0.1:3306/javaweb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    final String DBUSER = "root";
    final String DBPASS = "root";

    Connection conn = null;


    try{
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        PreparedStatement pstmt = conn.prepareStatement("delete from user where id=?");
        pstmt.setInt(1,Integer.parseInt(request.getParameter("id")));
        pstmt.execute();
    }catch(Exception e){
        out.println(e);
    }finally{
//	 		conn.close();
    }
    response.sendRedirect("student_info.jsp");
%>
</body>
</html>
