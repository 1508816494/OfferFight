package javabase;

import java.util.Scanner;

public class EnumStudy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter");
        String input = in.next().toUpperCase();

        Size size = Enum.valueOf(Size.class, input);
        //继承Enum的toString（），返回枚举常量名
        System.out.println("size=" + size);
        System.out.println("s =" + size.getS());

        //比较枚举类型用 ==
        if(size == Size.EXTRA_LARGE) {
            System.out.println("大啦，哈哈");
        }

        //静态values，返回包含全部枚举值的数组
        Size[] values = Size.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}

enum Size
{
    //刚好有如下实例，最好不要新构造
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    //缩写值
    private String s;

    Size(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}