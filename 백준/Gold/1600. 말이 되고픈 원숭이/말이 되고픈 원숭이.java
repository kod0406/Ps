import java.io.*;
import java.util.*;

class Main {

    static int[][] graph;
    static boolean[][][] isVisited;
    static int[] dx = {1, -1, 0, 0}; // 일반 이동: 상하좌우
    static int[] dy = {0, 0, 1, -1};
    static int[] h_dx = {2, 2, -2, -2, 1, 1, -1, -1}; // 말 이동: 체스 나이트
    static int[] h_dy = {1, -1, 1, -1, 2, -2, 2, -2};

    static int w, h, k;

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0}); // 시작점 x, y, 말 이동 횟수, 총 이동 횟수
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int horseMoves = curr[2];
            int moves = curr[3];

            // 목적지 도달
            if (x == h - 1 && y == w - 1) {
                return moves;
            }

            // 일반 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && !isVisited[nx][ny][horseMoves] && graph[nx][ny] == 0) {
                    isVisited[nx][ny][horseMoves] = true;
                    queue.offer(new int[]{nx, ny, horseMoves, moves + 1});
                }
            }

            // 말 이동 (남은 말 이동 횟수가 있을 때만)
            if (horseMoves < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + h_dx[i];
                    int ny = y + h_dy[i];
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w && !isVisited[nx][ny][horseMoves + 1] && graph[nx][ny] == 0) {
                        isVisited[nx][ny][horseMoves + 1] = true;
                        queue.offer(new int[]{nx, ny, horseMoves + 1, moves + 1});
                    }
                }
            }
        }
        return -1; // 목적지에 도달할 수 없는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine()); // 말 이동 횟수
        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);

        graph = new int[h][w];
        isVisited = new boolean[h][w][k + 1]; // [x][y][말 이동 횟수]

        for (int i = 0; i < h; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }
}
