import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int size = 4 * N - 3;
        char[][] grid = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }

        for (int i = 0; i < N; i++) {
            int start = 2 * i;
            int end = size - 2 * i - 1;
            for (int j = start; j <= end; j++) {
                grid[start][j] = '*';
                grid[end][j] = '*';
                grid[j][start] = '*';
                grid[j][end] = '*';
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bw.write(grid[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
    }
}