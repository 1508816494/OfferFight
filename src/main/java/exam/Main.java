package exam;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        int query1, query2;

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            String lineNums = scanner.nextLine();
            String[] nums = lineNums.split(" ");
            int[] numbers = new int[nums.length];

            System.out.println(nums.length);
            for(int i = 0; i < nums.length; i++) {
                numbers[i] = Integer.valueOf(nums[i]);
            }

            String querys = scanner.nextLine();
            String[] qs = querys.split(" ");

            query1 = Integer.valueOf(qs[0]);
            query2 = Integer.valueOf(qs[1]);

            int index1 = 0, index2 = 0;
            for(int f = 0; f < numbers.length; f++) {
                int val = numbers[f];
                if(val == query1) {
                    index1 = f;
                }
                if(val == query2) {
                    index2 = f;
                }
            }
            if(index1 == index2) {
                System.out.println(numbers[(index1 - 1)/2]);
            }
            if(index1 < index2) {
                while (true) {
                    int pIndex = (index2 -1)/2;

                }
            }
        }
    }
}

