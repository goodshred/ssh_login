package basejvm.lclassloader;



public class LClassLoader {
     public LClassLoader(){
         System.out.println(this.getClass().getClassLoader());
     }
    /**
     * String name是一个类的二进制字节流，就是.class这个文本
     */
  /*  public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }*/

    /**
     * 父类加载不是继承，它是包含和组合的关系
     * parent.loadClass（）------》findClass(name)
     * @param name--------传入类名，传入类路径，传入类的二进制名称
     *   1.已加载了吗？-------》2.父类加载器加载（为空的话）--------》3.从自定义加载器加载类（name就是类的文件名称）
     * @param resolve
     * @throws ClassNotFoundException
     */
/*    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                try {
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }*/
}
