package basejvm;

import basejvm.lclassloader.MyClassLoader;

import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int tmp=1;
    static{
        tmp=2;
        System.out.println(tmp);
    }
    public static void main( String[] args ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        tmp=3;
        System.out.println( tmp );

        System.out.println(App.class.getClassLoader());
        ClassLoader loader=App.class.getClassLoader();
        while(loader!=null){
            System.out.println(loader);
            loader=loader.getParent();
        }
        System.out.println("loader为空，说明改类加载器是BootstrapLoader，" +
                "它没有父类加载器。这也说明，类的加载是由它的父类加载器完成加载的:"+loader);


        MyClassLoader myClassLoader=new MyClassLoader("LMJ","D:\\Idea_workspace\\basejvm\\target\\classes\\basejvm\\");
        /**
         * 为空，代表Bootstrap ClassLoader加载器，他会回调findClass（），调用自定义的ClassLoader，也就是wukong类加载器，最总类就是wukong
         */
       MyClassLoader wuKongClassLoader=new MyClassLoader(null,"WuKonhClassLoader","D:\\Idea_workspace\\basejvm\\target\\classes\\basejvm\\");
     //  Class<?>wuKong=wuKongClassLoader.loadClass("basejvm.lclassloader.LClassLoader");
        Class<?>clazz=myClassLoader.loadClass("basejvm.lclassloader.LClassLoader");
       //  wuKong.getDeclaredConstructor().newInstance();
        clazz.getDeclaredConstructor().newInstance();
    }
}
