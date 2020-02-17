package exam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0921_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<Integer> result = new ArrayList<>();
            int size = scanner.nextInt();
            while (size-- > 0) {
                int len = scanner.nextInt();
                int[] arr = new int[len];
                for(int i = 0; i < len; i++) {
                    arr[i] = scanner.nextInt();
                }
                result.add(getLen(arr));
            }
            for(Integer item : result) {
                System.out.println(item);
            }
        }


    }

    private static int getLen(int[] arr) {
        int maxLen = 1;
        int index1 = 0;
        int index2 = 1;
        int sum = arr[index1];

        while (index2 < arr.length) {
            int currentVal = arr[index2];
            if(currentVal >= sum) {
                sum += currentVal;
                maxLen = Math.max(maxLen, index2 - index1 + 1);
                index2++;
            } else {
                sum -= arr[index1++];
                sum += arr[index2++];
            }
        }
        return maxLen;
    }
}
