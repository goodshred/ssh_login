package cn.sxt.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

public class AuthenticationDemo {
    public static void main(String[] args){
        //1.创建SecurityManager工厂，读取配置文件
        Factory<SecurityManager> factory= new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.通过SecurityManager获取SecurityManager实例，添加到运行环境
       SecurityManager securityManager=factory.getInstance();
       //3.将SecurityManager设置到运行环境
        SecurityUtils.setSecurityManager(securityManager);
        //4.通过securityUtils获取主体Subject,获取到就能做事了
        Subject subject=SecurityUtils.getSubject();
        try {
            //5.加入登陆的用户名，密码：张三/1111，shiro的张三，1111相当于数据里存放的信息
            UsernamePasswordToken token = new UsernamePasswordToken("lisi", "1111");
            //6.进行用户身份验证
            subject.login(token);
            //通过subject判断用户是否通过验证
            if (subject.isAuthenticated()) {
                System.out.println("用户登陆成功");
            }else {System.out.println("用户名或密码不正确");}
        }catch (AuthenticationException e){e.printStackTrace();
            System.out.println("用户登录失败");
        }
    }
}
