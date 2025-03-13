import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals(".")) {
                break;
            }

            String result = isBalanced(input) ? "yes" : "no";
            System.out.println(result);
        }

        scanner.close();
    }

    static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}