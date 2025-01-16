import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void hanoi(int brick, int start, int by, int end, BufferedWriter bw) throws IOException {
        // 1. 탈출 조건
        if (brick == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }
        // 2. 점화식
        hanoi(brick - 1, start, end, by, bw);
        bw.write(start + " " + end + "\n");
        hanoi(brick - 1, by, start, end, bw);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        // 최소 이동 횟수는 2^n - 1
        BigInteger big = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
        bw.write(big.toString() + "\n");

        if (n <= 20) {
            // 출력 내용이 많을 때는 BufferedWriter를 사용하여 효율적으로 출력
            hanoi(n, 1, 2, 3, bw);
        }
        
        bw.flush();
        bw.close();
    }
}
