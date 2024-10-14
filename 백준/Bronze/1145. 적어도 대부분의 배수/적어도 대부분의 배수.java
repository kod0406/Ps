import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int[] ary = new int[5];

        for (int i = 0; i < 5; i++) {
            ary[i] = Integer.parseInt(input[i]);
        }

        int result = Integer.MAX_VALUE;


        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int lcm = lcm(ary[i], ary[j], ary[k]);
                    result = Math.min(result, lcm);
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }


    public static int lcm(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }


    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }


    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}