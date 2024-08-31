import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        long[] dp_table = new long[n + 1];  // 배열 크기를 n+1로 설정
        dp_table[0] = 0;
        dp_table[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp_table[i] = dp_table[i - 1] + dp_table[i - 2];
        }

        bw.write(String.valueOf(dp_table[n]));  // n번째 피보나치 수 출력
        bw.flush();
    }
}
