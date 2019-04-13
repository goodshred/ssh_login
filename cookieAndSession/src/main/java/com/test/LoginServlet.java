package com.test;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.uwo9.entity.User;
import com.uwo9.service.IUserService;
import com.uwo9.service.impl.UserServiceImpl;
 
public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 4296005247016878230L;
 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
 
		// 接收请求参数
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
 
		// 调用Service层相应方法进行处理
		// 创建业务层对象
		IUserService userService = new UserServiceImpl();
		User user = userService.login(uname, pwd);
 
		// 根据业务层返回值进行响应
		if (user != null) {
			// 判断是否需要记住密码
			String remember = req.getParameter("remember");
 
			// 判断
			if (remember != null && remember.equals("1")) {// 需要记住密码
				// 将用户名和密码存放在cookie对象中
				Cookie cookie = new Cookie("userInfo", uname + ":" + pwd);
				// 设置有效时间三天
				cookie.setMaxAge(3 * 24 * 60 * 60);
				// 设置有效页面
				cookie.setPath("/uwo9/login.jsp");
				// 将cookie对象存放至response
				resp.addCookie(cookie);
 
			}else {
				// 将用户名和密码存放在cookie对象中
				Cookie cookie = new Cookie("userInfo", uname + ":" + pwd);
				// 设置
				cookie.setMaxAge(0);
				// 设置有效页面
				cookie.setPath("/uwo9/login.jsp");
				// 将cookie对象存放至response
				resp.addCookie(cookie);
			}
 
			//将user对象存放至session对象中
			req.getSession().setAttribute("user", user);
			
			// resp.getWriter().print("欢迎" + user.getUsername() + "登录成功！");
			// 请求转发
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		} else {
			// resp.getWriter().print("登录失败！");
			// 设置错误提示信息
			// req.getSession().setAttribute("errorInfo","用户名或密码错误！");
			// 重定向
			resp.sendRedirect("login.jsp");
		}
 
	}
}
