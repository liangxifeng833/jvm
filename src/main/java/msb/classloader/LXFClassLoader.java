package msb.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义类加载器
 */
public class LXFClassLoader extends ClassLoader{
    protected Class<?> fincClass(String name) throws ClassNotFoundException {
        File f = new File("d:/test/",name.replaceAll(".","/"));
        try{
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b=fis.read()) != 0) {
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            return defineClass(name,bytes,0,bytes.length);
        }catch (Exception e) {
            e.printStackTrace();;
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //new 自定义的类加载器
        ClassLoader l = new LXFClassLoader();
        //使用自定义的类加载器加载制定的clss文件到内存中，
        // 也就是在内存中创建一个名为Hello的Class对象,通过该对象访问云空间中的类代码信息，也就是反射
        Class clazz = l.loadClass("msb.classloader.Hello");
        //通过class对象，创建新对象
        Hello hello = (Hello) clazz.newInstance();
        hello.sahHello();
        System.out.println( l.getClass().getClassLoader() ); //打印类加载器
        System.out.println(l.getParent().getParent()); //打印l的父类加载器

    }
}
