package basejvm.lclassloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String path;   //类路径
    private String name;   //类名称
    public MyClassLoader(String name,String path){
        super();  //让系统类加载器成为该类的类加载器
        this.name=name;
        this.path=path;
    }
    public MyClassLoader(ClassLoader parent, String name,String path){
        super(parent);  //显示执行父加载器
        this.name=name;
        this.path=path;
    }

    /**
     * 记载自定义的类,获取class文件，转为二进制数组
     * basejvm.lclassLoader.App---------相对路径转绝对路径
     * @param  name
     *         The <a href="#name">binary name</a> of the class
     */
    @Override
      protected Class<?>findClass (String name ) throws ClassNotFoundException{
        byte[] data=readFileToByteArray(name);
        return super.defineClass(name,data,0,data.length);
    }

    private byte[] readFileToByteArray(String name) {
        name=name.replaceAll("\\.","/");
        InputStream inputStream=null;
        byte[] data=null;

        File file=new File(this.path+name+".class");
        ByteArrayOutputStream byteArrayOutStream=new ByteArrayOutputStream();
        try{
            inputStream=new FileInputStream(file);
            int a=0;
            while((a=inputStream.read())!=-1){
                byteArrayOutStream.write(a);
            }
        }catch (Exception e){e.printStackTrace();}finally{
            try{
                inputStream.close();
                byteArrayOutStream.close();
            }catch (Exception e){e.printStackTrace();}

        }
        return data;
    }
}
