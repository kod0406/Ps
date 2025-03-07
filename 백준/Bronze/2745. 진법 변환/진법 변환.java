import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        String val = input[0];
        int digit = Integer.parseInt(input[1]);
        bw.write(String.valueOf(toDecimal(val, digit)));
        bw.flush();
    }

    public static int toDecimal(String val, int digit) {
        int result = 0;
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            int num = 0;
            if (c >= 'A' && 'Z' >= c) {
                num = c - 55;
            } else {
                num = c - '0';
            }
            result += (int) (num * Math.pow(digit, val.length() - i - 1));

        }
        return result;
    }
}