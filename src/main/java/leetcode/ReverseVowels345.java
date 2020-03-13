package leetcode;

public class ReverseVowels345 {
    public static String reverseVowels(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if(judge(chars[i])) {
                if(judge(chars[j])) {
                    //不等时才交换
                    if(chars[i] != chars[j]) {
                        swap(chars, i, j);
                        i++;
                        j--;
                    }
                } else {
                    //不为元音跳过
                    j--;
                }
            } else {
                //不为元音跳过
                i++;
            }
        }
        return String.valueOf(chars);
    }

    public static boolean judge(char c){
        if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u' && c!='A' && c!='E' && c!='I' && c!='O' && c!='U'){
            return false;
        } else {
            return true;
        }
    }
    

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
