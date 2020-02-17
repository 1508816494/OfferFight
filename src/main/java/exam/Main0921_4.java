package exam;


import java.util.Scanner;

public class Main0921_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int index = 0;
            int[] arr = new int[len];
            while (index < len) {
                arr[index++] = scanner.nextInt();
            }
            System.out.println(getSum(arr));
        }
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int current = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                int next = arr[j];
                if(current > next) {
                    sum += (current - next);
                }
            }
        }
        return sum;
    }
}
