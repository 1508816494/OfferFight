package exam;

import java.util.Scanner;

public class MainDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num;

        while (in.hasNext()) {
            num = in.nextInt();

            //in.nextLine会返回当前行剩余的，所以当输入一个整数后会返回一个空串
            String line = in.nextLine();

//            //未给出记录的条数
//            while (in.hasNext()) {
//
//                String line = in.nextLine();
//
//                String[] split = line.split("");
//
//                for (int i = 0; i < split.length; i++) {
//                    System.out.print(split[i]);
//                }
//
//                System.out.println("");
//            }

            //给出记录的条数
            for (int i = 0; i < num; i++) {

                //不确定一行有几个数据以及类型不同,否则则可以直接使用in.next()
                line = in.nextLine();

                String[] split = line.split("");

                for (int j = 0; j < split.length; j++) {
                    System.out.print(split[j]);
                }

                System.out.println("");
            }


        }
    }
}
