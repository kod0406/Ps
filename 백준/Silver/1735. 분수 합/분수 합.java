import java.io.*;

public class Main {
    // 유클리드 호제법
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 최소공배수(호재법 사용)
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstFraction = br.readLine().split(" ");
        int a1 = Integer.parseInt(firstFraction[0]);
        int b1 = Integer.parseInt(firstFraction[1]);

        String[] secondFraction = br.readLine().split(" ");
        int a2 = Integer.parseInt(secondFraction[0]);
        int b2 = Integer.parseInt(secondFraction[1]);

        // 분모의 최소공배수 구하기
        int lcm = lcm(b1, b2);

        // 분자를 맞춰서 더하기
        int numerator = a1 * (lcm / b1) + a2 * (lcm / b2);
        int denominator = lcm;

        // 결과 분수를 기약분수로 만들기
        int gcdResult = gcd(numerator, denominator);
        numerator /= gcdResult;
        denominator /= gcdResult;

        // 결과 출력
        bw.write(String.valueOf(numerator)+ " "+String.valueOf(denominator));
        bw.flush();
    }
}
