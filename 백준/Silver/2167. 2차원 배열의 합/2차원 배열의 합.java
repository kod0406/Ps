import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        int[][] arr = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1];
        

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = scanner.nextInt();

                sum[i][j] = arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        
        int K = scanner.nextInt();
        
        StringBuilder sb = new StringBuilder();
        

        for (int q = 0; q < K; q++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            int result = sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1];
            sb.append(result).append("\n");
        }
        
        System.out.print(sb.toString());
        scanner.close();
    }
}
