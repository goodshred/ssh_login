package springboohi;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

//@ImportResource(locations = {"classpath:beans.xml"})  //导入自己的配置文件，可用配置类代替
@SpringBootApplication
public class SpringBootApp {
     //该类必须是@SpringBootApplication注解的类，主配置类，
     //该注解是组合配置，@SpringBootApplication------>@SpringBootConfiguration------>@Configuration(spring底层)---->@Component
     //@EnableAutoConfiguration---->@AutoConfigurationPackage---->@Import({Registrar.class})[spring底层的东西，该导入那些组件@Component]
    //@Import({Registrar.class）  Registrar类它将主配置类（@SpringBootApplication注解的类）的所在包及下面所有子包里面的所有组件扫描到spring容器（然后就可以对类进行AOP，IOC和DI了）
    //@Import({AutoConfigurationImportSelector.class})将要导入的组件（装入数组）以全类名的方式返回
    //自动配置类里面的实现 beanFactory.getBean ，
   /*  protected List<AutoConfigurationImportFilter> getAutoConfigurationImportFilters() {
        允许配置的类和类加载器
         return SpringFactoriesLoader.loadFactories(AutoConfigurationImportFilter.class, this.beanClassLoader);
     }*/

    /**
     * Springboot推荐使用全注解类方式
     *所有的配置都由自动配置类完成
     * org.springframework.boot：spring-boot-autoconfigure的jar包下的spring.factories声明了允许自动配置的类
     *servlet的配置，sucrity的配置，拦截器的配置，数据库连接的配置
     * springboot就是用配置类替代xml配置，用jpa替代hbm.xml的配置
     * 就是这些包org.springframework.boot.autoconfigure.*实现了零配置
     *
     * spring默认使用common-lang日志，spriongboot选择的是self4j和logback
     * self4j统一日志原理：  将系统其他日志框架先排除，用中间包替换原有日志框架，【这是门面日志做的工作，偷梁换柱】，然后再导入self4j去实现，所以它自动适配所有日志框架
     在pom.xml中双击shift可查看具体的类的源码，或者ctrl+n
     */


    /**学习springboot需要搞懂这几个问题
        1.它是如何通过自动配置类完成springmvc的
        2.它是如何解析请求，完成客户端请求的参数的封装的，如何视图解析的，如和拦截url的
     */

    //增加(Create)、读取查询(Retrieve)========crud
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }



    //视图解析器的原理
 /*   @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    private static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale)throws Exception{
            return null;
        }
    }*/
}