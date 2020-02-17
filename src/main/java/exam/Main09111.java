package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main09111 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line1 = "";
        String line2 = "";

        while (in.hasNext()) {
            line1 = in.nextLine();
            line2 = in.nextLine();

            Set<Character> set = new HashSet<>();

            for(int i = 0; i < line2.length(); i++) {
                set.add(line2.charAt(i));
            }

            for(int j = 0; j < line1.length(); j++) {
                if(set.contains(line1.charAt(j))) {
                    String s = line1.charAt(j) + "";
                    line1 = line1.replace(s, "");
                }
            }
            System.out.println(line1);
        }
    }
}
