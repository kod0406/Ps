import java.io.*;
import java.util.*;

class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int graph[][];
    static int value[][];
    static boolean is_visited[][];
    static int N, M;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    
    public static void bfs(int start_x, int start_y) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start_x, start_y});
        is_visited[start_x][start_y] = true;
        value[start_x][start_y] = 0;

        while (!q.isEmpty()) {
            int crt[] = q.poll();
            int crt_x = crt[0];
            int crt_y = crt[1];

            for (int i = 0; i < 4; i++) {
                int nx = crt_x + dx[i];
                int ny = crt_y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !is_visited[nx][ny] && graph[nx][ny] != 0) {
                    q.offer(new int[]{nx, ny});
                    is_visited[nx][ny] = true;
                    value[nx][ny] = value[crt_x][crt_y] + 1;
                }
            }
        }
    }

    public static void print_value() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    bw.write("0 ");
                } else if (!is_visited[i][j]) {
                    bw.write("-1 ");  // 도달할 수 없는 곳은 -1
                } else {
                    bw.write(String.valueOf(value[i][j]) + " ");
                }
            }
            bw.newLine();
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        graph = new int[N][M];
        value = new int[N][M];
        is_visited = new boolean[N][M];

        int start_x = -1, start_y = -1;

        for (int i = 0; i < N; i++) {
            String input_line[] = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(input_line[j]);
                if (graph[i][j] == 2) {
                    start_x = i;
                    start_y = j;
                }
            }
        }
        bfs(start_x, start_y);
        print_value();
    }
}
