import java.io.*;
import java.util.*;

class Main {

    public static String stk(String srt, String bomb) {
        Stack<Character> stack = new Stack<>();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < srt.length(); i++) {
            stack.push(srt.charAt(i));
            buffer.append(stack.peek());
            if (buffer.length() >= bomb.length() && buffer.substring(buffer.length() - bomb.length()).equals(bomb)) {
                buffer.delete(buffer.length() - bomb.length(), buffer.length());
                for (int j = 0; j < bomb.length(); j++) {
                    stack.pop();
                }
            }
        }
        return buffer.length() == 0 ? "FRULA" : buffer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String bomb = br.readLine();

        bw.write(stk(str, bomb));
        bw.flush();
    }
}