import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행렬 A의 크기 N과 M 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 행렬 A 입력
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 행렬 B의 크기 M과 K 입력
        int M2 = sc.nextInt();
        int K = sc.nextInt();

        // M과 M2는 동일하므로 M == M2여야 한다.
        if (M != M2) {
            System.out.println("행렬 곱셈이 불가능합니다.");
            return;
        }

        // 행렬 B 입력
        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // 결과 행렬 C 크기는 N x K
        int[][] C = new int[N][K];

        // 행렬 곱셈 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // 결과 행렬 C 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
