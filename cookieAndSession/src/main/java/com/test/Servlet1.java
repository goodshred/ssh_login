package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/session1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session1 = req.getSession();

        session1.setAttribute("name", "jerry");

        String id = session1.getId();//该session对象的编号id
        //手动创建一个存储JSESSIONID的Cookie 为该cookie设置持久化时间
        Cookie cookie = new Cookie("JSESSIONID",id);
        cookie.setPath("/WEB16/");
        cookie.setMaxAge(60*10);

        resp.addCookie(cookie);
        resp.getWriter().write("JSESSIONID:"+id);
    }

}
