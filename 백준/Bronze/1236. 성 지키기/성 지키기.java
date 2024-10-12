import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);

        boolean[] rowGuard = new boolean[N];
        boolean[] colGuard = new boolean[M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'X') {
                    rowGuard[i] = true;
                    colGuard[j] = true;
                }
            }
        }

        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < N; i++) {
            if (!rowGuard[i]) {
                rowCount++;
            }
        }

        for (int j = 0; j < M; j++) {
            if (!colGuard[j]) {
                colCount++;
            }
        }

        System.out.println(Math.max(rowCount, colCount));
    }
}