import java.util.*;

public class Solution {
    public int calPoints(String[] ops) {
        if (ops.length == 0 || ops == null) {
            return 0;
        }
        int ans = 0;
        int[] scores = new int[ops.length];
        Set<Integer> invaild = new HashSet<>();

        for (int i = 0; i < ops.length; i++) {
            int j = i - 1;
            if (ops[i].equals("C")) {
                invaild.add(i);
                while (j >= 0) {
                    if (!invaild.contains(j)) {
                        invaild.add(j);
                        break;
                    }
                    j--;
                }
            } else if (ops[i].equals("D")) {
                while (j >= 0) {
                    if (!invaild.contains(j)) {
                        scores[i] = 2 * scores[j];
                        break;
                    }
                    j--;
                }
            } else if (ops[i].equals("+")) {
                int count = 0;
                while (j >= 0) {
                    if (!invaild.contains(j)) {
                        scores[i] += scores[j];
                        count++;
                    }
                    j--;
                    if (count == 2) {
                        break;
                    }
                }
            }else {
                scores[i] = Integer.valueOf(ops[i]);
            }
        }

        for (int i = 0; i < scores.length; i++) {
            if (!invaild.contains(i)) {
                ans += scores[i];
            }
        }
        return ans;
    }

    public int calPoints1(String[] ops) {
        int ans = 0;
        Stack<Integer> validStack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("D")) {
                validStack.push(validStack.peek() * 2);
            } else if (ops[i].equals("C")) {
                validStack.pop();
            } else if (ops[i].equals("+")) {
                int num1 = validStack.pop();
                int num2 = validStack.pop();
                validStack.push(num2);
                validStack.push(num1);
                validStack.push(num1 + num2);
            } else {
                validStack.push(Integer.valueOf(ops[i]));
            }
        }

        while (!validStack.isEmpty()) {
            ans += validStack.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] ops1 = {"5", "2", "C", "D", "+"};
        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        String[] ops3 = {"-60", "D", "-36", "30", "13", "C", "C", "-33", "53", "79"};
        Solution solution = new Solution();
        System.out.println(solution.calPoints1(ops1));
        System.out.println(solution.calPoints1(ops2));
        System.out.println(solution.calPoints1(ops3));
    }
}
