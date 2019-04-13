package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/hello")
public class ShowLastAccessTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得当前时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String currentTime1 = format.format(date);
        // 以上可简写为：
        // String currenttime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        //字符串currentTime1中包含空格，存入cookie时会报错，
       // 当cookie中包含有等号、空格、分号等特殊字符时，可能会导致数据丢失、
        // 或者不能解析的错误，一个较好的解决办法就是：在将cookie值写入客户端浏览器之前，
        // 首先进行URLEncode编码，读取cookie时，进行URLDecode即可
        String currentTime=URLEncoder.encode(currentTime1, "UTF-8");

        Cookie cookie=new Cookie("lastAccessTime",currentTime);
        //cookie.setMaxAge(0);
        // 设为0，就是清空cookie的意思，可用于退出系统
        cookie.setMaxAge(10*60);   //设置有效期为60分钟
        resp.addCookie(cookie);
        String lastAccesstime=null;
        Cookie[] cookies=req.getCookies();
        if (cookies!=null){
            for(Cookie coo:cookies){
                if("lastAccessTime".equals(coo.getName())){
                    lastAccesstime=coo.getValue();
                }
            }
        }
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        if (lastAccesstime==null){
            out.write("第一次访问");
        } else {
            String time=URLDecoder.decode(lastAccesstime, "UTF-8");
            out.write("上次访问时间是："+time );
        }

    }

  /* 以上可简写为：
        // String currenttime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        //字符串currentTime1中包含空格，存入cookie时会报错，
       // 当cookie中包含有等号、空格、分号等特殊字符时，可能会导致数据丢失、
        // 或者不能解析的错误，一个较好的解决办法就是：在将cookie值写入客户端浏览器之前，
        // 首先进行URLEncode编码，读取cookie时，进行URLDecode即可*/
}
