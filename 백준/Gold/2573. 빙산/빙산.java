import java.io.*;
import java.util.*;

class Main {
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int x, y;
    static int graph[][];
    static int ice[][];
    static boolean is_visited[][];

    // 빙산 덩어리 개수를 세는 메서드
    public static int area() {
        is_visited = new boolean[x][y];
        int cnt = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (graph[i][j] > 0 && !is_visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // BFS를 이용한 빙산 영역 탐색
    public static void bfs(int start_x, int start_y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start_x, start_y});
        is_visited[start_x][start_y] = true;

        while (!q.isEmpty()) {
            int[] cnt = q.poll();
            int cnt_x = cnt[0];
            int cnt_y = cnt[1];
            for (int i = 0; i < 4; i++) {
                int nx = cnt_x + dx[i];
                int ny = cnt_y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < x && ny < y && graph[nx][ny] > 0 && !is_visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    is_visited[nx][ny] = true;
                }
            }
        }
    }

    // 빙산을 녹이는 메서드
    public static void melting() {
        ice = new int[x][y];
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (graph[i][j] > 0) {
                    int waterCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < x && ny < y && graph[nx][ny] == 0) {
                            waterCount++;
                        }
                    }
                    // 녹은 후 높이를 음수로 가지지 않게 함
                    ice[i][j] = Math.max(0, graph[i][j] - waterCount);
                }
            }
        }
        
        for (int i = 0; i < x; i++) {
            System.arraycopy(ice[i], 0, graph[i], 0, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        graph = new int[x][y];
        
        for (int i = 0; i < x; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        int years = 0;
        while (true) {
            int cnt = area();
            
            if (cnt >= 2) {
                bw.write(String.valueOf(years));
                bw.flush();
                break;
            } else if (cnt == 0) {
                bw.write("0\n");
                bw.flush();
                break;
            }

            melting();
            years++;  // 1년 증가
        }
    }
}
