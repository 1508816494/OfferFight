package exam;

import java.util.*;

public class Main0920_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.nextLine();
            String str = in.nextLine().trim();

            if(n < 11) {
                System.out.println("NO");
                continue;
            }

            int index = str.indexOf(8);

            if(str.length() - index < 11) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
