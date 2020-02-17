package exam;


import java.util.Scanner;

public class Main0921_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for(int i = 0; i < count; i++) {
            int num = scanner.nextInt();

            //只有一位
            if(num/10 == 0) {
                System.out.println(num);
                continue;
            }


            int sum = 9;
            int res = 9;
            int layer = 0;
            while (sum < num) {
                layer++;
                int k = 1;
                while (k <= 9){
                    sum = res + k;
                    k++;
                    if(sum >= num) {
                        k--;
                        int temp = 1;
                        while (layer > 0) {
                            temp = temp * 10;
                            layer--;
                        }

                        res = res + k * temp;
                        break;
                    }
                }
            }
            System.out.println(res);

        }
    }

}
