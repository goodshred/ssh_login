package com.test;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MySession extends HttpServlet {
 /*   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得当前时间
        //通过小的能获取到大的
        //当你写完这句代码后，session就永不为空，故不增加判空条件了
        //servlet1和sevlet2处于同一个session中，故session是相同的
        Session session = (Session) req.getSession();


        //从session中获得存储的数据
        HttpSession session = request.getSession();
不能写成String attribute =  session.getAttribute("name");应为null不能转为String
        Object attribute =  session.getAttribute("name");

        response.getWriter().write(attribute+"");
    }*/
}
