import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3]; // 각 집을 빨강, 초록, 파랑으로 칠할 때 최소 비용
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int[] label = {
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2])
            };

            if (i == 0) {
                // 첫 번째 집 초기화
                dp[0][0] = label[0];
                dp[0][1] = label[1];
                dp[0][2] = label[2];
            } else {
                // 두 번째 집부터는 이전 집의 최소 비용을 이용해 계산
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + label[0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + label[1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + label[2];
            }
        }

        // 마지막 집의 최소 비용 중 가장 작은 값을 출력
        int result = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
