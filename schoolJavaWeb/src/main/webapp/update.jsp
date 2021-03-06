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

    <title>My JSP 'emp.jsp' starting page</title>

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
    final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    final String DBURL = "jdbc:mysql://127.0.0.1:3306/javaweb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    final String DBUSER = "root";
    final String DBPASS = "root";

    Connection conn = null;
    try{
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        //System.out.println(conn);
        String sql = "select id,username,password,email from user where id=?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,Integer.parseInt(request.getParameter("id")));
        ResultSet rs = pstmt.executeQuery();
%>
<center>
    <div style="background:white">

        <p>用户全部信息表</p>
        <form action="update_save.jsp" method="post">
            <table border="0" align="center" width="800" bgcolor=#f1c4cd>
                <tr>
                    <td>序号</td>
                    <td>姓名</td>
                    <td>密码</td>
                    <td>邮箱</td>
                    <td colspan="2">操作</td>
                </tr>

                <%
                    while(rs.next()){
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        String  password = rs.getString(3);
                        String email = rs.getString(4);

                %>

                <tr>
                    <td><input type="text" name="id" value="<%=id %>"></td>
                    <td><input type="text" name="name" value="<%=name %>"></td>
                    <td><input type="text" name="password" value="<%=password %>"></td>
                    <td><input type="text" name="email" value="<%=email %>"></td>
                    <td><a href="update.jsp?id=<%=id %>" style="color: red">更新</a></td>
                    <td><a href="delete.jsp?id=<%=id %>" style="color: red">删除</a></td>
                </tr>

            </table>
            <input type="submit" value="保存">
            <input type="reset" value="重置">
        </form>
    </div>
</center>
<%
        }
        rs.close();
        pstmt.close();
    }catch(Exception e){
        out.println(e);
    }finally{
        conn.close();
    }
%>
</body>
</html>
