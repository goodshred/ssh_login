<%@ page import="java.sql.*" %><%--
 <% %>定义 局部变量
 <%! %>定义全局变量
 解决乱码的四种方式
 <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf8");response.setCharacterEncoding("utf8");%>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf8");
    String lname=request.getParameter("username");
    String lpassword=request.getParameter("password");
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    if (!("".equals(lname)&&lname!=null&&"".equals(lpassword)&&lpassword!=null)){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             conn = DriverManager.getConnection(
                    "jdbc:mysql:localhost:3306/javaweb?useUnicode=true&characterEncoding=utf8serverTimezone=GMT%2B8&useSSL=false",
                    "root", "root");
             ps = conn.prepareStatement(
                    "select password from user where username=?0 and password=?1");
            ps.setString(0, lname);
            ps.setString(1, lpassword);
             rs = ps.executeQuery();
            if (rs.next()) {
                Cookie cookie = new Cookie("username", lname);
                cookie.setMaxAge(60 * 60 * 5);//以秒为单位(这里设置为保留5小时)
                Cookie cookie1 = new Cookie("password", lpassword);
                cookie1.setMaxAge(60 * 60 * 5);//以秒为单位
                response.addCookie(cookie);
                response.addCookie(cookie1);
                HttpSession session1 = request.getSession();
                session1.setAttribute("username", lname);
                session1.setAttribute("password", lpassword);
                rs.close();
                ps.close();
                conn.close();






%>

<jsp:forward page="student_info.jsp">
   <%-- <jsp:param name="username" value="<%=lname%>"></jsp:param>--%>
</jsp:forward>
 <%
    } else{%><jsp:forward page="failed.jsp"></jsp:forward><% }}catch (SQLException e){System.out.println(e.toString());}}else {%>
<jsp:forward page="failed.jsp"></jsp:forward>
<%}%>
</body>
</html>
