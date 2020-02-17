package jvm;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    //将类名变为全类名
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    //根据名称或位置加载字节码
                    InputStream is = getClass().getResourceAsStream(fileName);

                    //未加载则先抛给父类加载器加载
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    //is.available 返回可以读取的字节数的估计值
                    byte[] b = new byte[is.available()];
                    is.read(b);

                    //解析并定义字节流，返回class对象
                    return defineClass(name, b, 0, b.length);

                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass(MyClassLoader.class.getName()).newInstance();

        System.out.println(obj.getClass());

        System.out.println(obj instanceof MyClassLoader);
    }
}
