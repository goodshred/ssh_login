package com.test.cookieandsession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/keeploginservlet")
public class KeepLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public KeepLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


       /* HttpSession session = request.getSession();

        //创建验证码图片流
        ValidateCode validateCode = new ValidateCode(120,50,4,20);
        validateCode.write(response.getOutputStream());

        //将验证码存入session中
        session.setAttribute("vcode", validateCode.getCode());


        HttpSession session = request.getSession();

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 从session中获取验证码
        String vcode = (String) session.getAttribute("vcode");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
D:\softManager\install\maven-3.5.4\apache-maven-3.5.4\local_resposity\javax\javaee-api\7.0\javaee-api-7.0.jar
        PrintWriter out = response.getWriter();

        // System.out.println("输入的code:"+code);
        // System.out.println("生成的vcode:"+vcode);

        if (!vcode.equals(code)) {
            out.write("<html>"
                    + "<head><script type='text/javascript'> alert('验证码错误!');location='login.html';</script></head>"
                    + "<body></body></html>");
            return; // 不继续执行，重新返回login.html页面
        }

        if ("123".equals(username)) {
            if ("123".equals(password)) {

                // 创建cookie并将成功登陆的用户保存在里面
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60); // 设置一分钟有效
                response.addCookie(cookie); // 服务器返回给浏览器cookie以便下次判断

                response.sendRedirect(request.getContextPath() + "/index.html"); // 重定向到index.html
            } else {
                out.write("<html>"
                        + "<head><script type='text/javascript'> alert('密码错误!');location='login.html';</script></head>"
                        + "<body></body></html>");
                return;
            }
        } else {
            out.write("<html>"
                    + "<head><script type='text/javascript'> alert('不存在该用户!');location='login.html';</script></head>"
                    + "<body></body></html>");
            return;
        }
    }*/
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
