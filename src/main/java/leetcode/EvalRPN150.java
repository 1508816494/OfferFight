package leetcode;

import java.util.LinkedList;

public class EvalRPN150 {

    public static int evalRPN(String[] tokens) {

        LinkedList<String> stack = new LinkedList<>();

        for(int i = 0; i < tokens.length; i++) {

            if(!tokens[i].equals("+" )&& !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                stack.push(tokens[i]);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());


                switch (tokens[i]) {
                    case "+":
                        stack.push(b + a + "");
                        break;
                    case "-":
                        stack.push(b - a + "");
                        break;
                    case "*":
                        stack.push(b * a + "");
                        break;
                    default:
                        stack.push(b / a + "");
                        break;
                }

            }
        }
        if(!stack.isEmpty()) {
            return Integer.valueOf(stack.pop());
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        String[] arr = {"2", "1", "+", "3", "*"};

        int res = EvalRPN150.evalRPN(arr);
        System.out.println(res);
    }
}
