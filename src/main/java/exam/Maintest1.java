package exam;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Maintest1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int x = in.nextInt();//记录数；

        int A = in.nextInt();//时间值；

        int[][] a = new int[x][3];//记录信息；

        for(int i = 0; i <x ; i++) {

            for(int j = 0; j <3; j++) {

                a[i][j] = in.nextInt();

            }

        }


        TreeSet<Integer> set = new TreeSet<>();


        for(int i = 0; i < x ; i++) {

            for(int j = 0; j < 3; j++) {

                if(a[i][1] <= A && A <= a[i][2]){

                    set.add(a[i][0]);

                }

            }

        }

        if(set.size()==0)

            System.out.println("null");

        Iterator it = set.iterator();

        int k = 0;

        while(it.hasNext())//判断是否有下一个

        {

            k = (int) it.next();

            System.out.println(k);

        }

    }
}
