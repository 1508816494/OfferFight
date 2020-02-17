package exam;

import java.util.Scanner;

public class Main0911_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line1;
        String line2;

        while (in.hasNext()) {

            line1 = in.nextLine();
            line2 = in.nextLine();
            replace(line1, line2);
        }
    }

    static void replace(String source, String tar) {
        for(int i = 0; i < tar.length(); i++) {
            String item = tar.charAt(i) + "";
            source = source.replace(item, "");
        }
        System.out.println(source);
    }
}
