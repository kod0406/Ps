import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ary[] = new int[n];
        String input[] = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(input[i]);
        }
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(ary[i] > ary[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = Arrays.stream(dp).max().getAsInt();
        bw.write(String.valueOf(maxLength));
        bw.flush();
    }
}