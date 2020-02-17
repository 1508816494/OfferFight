package javabase;

public class StringTest {
    public static void main(String[] args) {
        /**
         * string intern()  string pool
         */
        //堆中对象，同时"a"早已存在常量池中,因此会被ignore
        String s = new String("a");
        s.intern();

        //常量池中
        String s2 = "a";
        System.out.println(s == s2); //false

        //s3，s4都指向常量池中
        String s3 = s.intern();
        String s4 = s.intern();
        System.out.println(s3 == s4); //true

        //s5指向堆中对象"aa" ，常量池中只包含"a"
        String s5 = new String("a") + new String("a");
        //将堆中的对象引用传给常量池 (1.6以下，常量池中存放的是堆中的副本，地址不同）
        s5.intern();
        //引用常量池中的常量（为堆中对象的引用）
        String s6 = "aa";
        System.out.println(s5 == s6); //true

        /**
         * 隐式类型转换
         */
        //s1为short类型，值为1
        short s1 = 1;
        //s1为short类型，而未指定类型的字面量1为int类型，和为int，不能传给short类型引用
//        s1 = s1 + 1;
        //进行自动类型转换 相当于进行了向下转型s1 = (short) (s1 + 1)
        s1 += 1;

        /**
         * switch java7开始可用string字面量 （char,byte,short,int,enum）
         */
        String yyt = "t";
        switch (yyt) {
            case "a":
                System.out.println("a");
                break;
            case "t":
                System.out.println("t");
                break;
             default:
                 System.out.println("hello");
        }


    }
}
