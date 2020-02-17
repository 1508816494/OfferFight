package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class IsValid20 {
    public boolean isValid(String s) {

        LinkedList<Character> st = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            //左括号入栈
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
                continue;
            }

            Character top = st.peek();

            //取到值在栈中无值对应，return false
            if(top == null) {
                return false;
            }

            //判断左边的值是否对应
            if(s.charAt(i) == ')') {
                if(top == '(') {
                    st.pop();
                    continue;
                } else {
                    return false;
                }
            }

            if(s.charAt(i) == ']') {
                if(top == '[') {
                    st.pop();
                    continue;
                } else {
                    return false;
                }

            }

            if(s.charAt(i) == '}') {
                if(top == '{') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        //取完所有值，栈中仍有剩余的，return false
        if(st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
