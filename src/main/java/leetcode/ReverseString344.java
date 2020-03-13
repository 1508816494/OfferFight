package leetcode;

public class ReverseString344 {
    public static void reverseString(char[] s) {
        if(s.length == 0) {
            return;
        }

        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
