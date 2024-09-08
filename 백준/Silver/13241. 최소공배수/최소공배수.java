import java.io.*;
import java.util.*;

public class Main {
    // 최대공약수(GCD) 함수
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM) 함수
    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(lcm(A, B));
    }
}