import java.io.*;
import java.util.*;

class Main {

    static int graph[][];
    static boolean is_visited[][];
    static int x;
    static int nx[] = {1, -1, 0, 0};
    static int ny[] = {0, 0, 1, -1};
    static int island_number = 2; // 섬 번호는 2부터 시작

    public static int find_min(int island_id) {
        Queue<int[]> q = new LinkedList<>();
        boolean visited_bfs[][] = new boolean[x][x];

        // 가장자리 셀 찾기
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (graph[i][j] == island_id) {
                    for (int k = 0; k < 4; k++) {
                        int dx = i + nx[k];
                        int dy = j + ny[k];
                        if (dx >= 0 && dx < x && dy >= 0 && dy < x && graph[dx][dy] == 0) {
                            q.offer(new int[]{i, j, 0}); // {x좌표, y좌표, 거리}
                            visited_bfs[i][j] = true;
                            break; // 한 번 큐에 넣었으면 더 이상 탐색할 필요 없음
                        }
                    }
                }
            }
        }

        // BFS로 최소 다리 길이 찾기
        while (!q.isEmpty()) {
            int cnt[] = q.poll();
            int cnt_x = cnt[0];
            int cnt_y = cnt[1];
            int distance = cnt[2];

            for (int i = 0; i < 4; i++) {
                int dx = cnt_x + nx[i];
                int dy = cnt_y + ny[i];

                if (dx >= 0 && dx < x && dy >= 0 && dy < x && !visited_bfs[dx][dy]) {
                    visited_bfs[dx][dy] = true;
                    if (graph[dx][dy] == 0) {
                        q.offer(new int[]{dx, dy, distance + 1});
                    } else if (graph[dx][dy] != island_id) {
                        return distance;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void island_numbering(int start_x, int start_y) { // 섬들의 번호를 매기는 메서드
        graph[start_x][start_y] = island_number;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start_x, start_y});
        is_visited[start_x][start_y] = true;

        while (!q.isEmpty()) {
            int cnt[] = q.poll();
            int cnt_x = cnt[0];
            int cnt_y = cnt[1];

            for (int i = 0; i < 4; i++) {
                int dx = cnt_x + nx[i];
                int dy = cnt_y + ny[i];

                if (dx >= 0 && dx < x && dy >= 0 && dy < x && graph[dx][dy] != 0 && !is_visited[dx][dy]) {
                    q.offer(new int[]{dx, dy});
                    graph[dx][dy] = island_number;
                    is_visited[dx][dy] = true;
                }
            }
        }

        island_number++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        x = Integer.parseInt(br.readLine());
        graph = new int[x][x];
        is_visited = new boolean[x][x];

        for (int i = 0; i < x; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 섬 번호 매기기
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (!is_visited[i][j] && graph[i][j] == 1) {
                    island_numbering(i, j);
                }
            }
        }

        // 최소 다리 길이 찾기
        int min_bridge_length = Integer.MAX_VALUE;

        for (int i = 2; i < island_number; i++) { // 각 섬에 대해 최소 거리 계산
            min_bridge_length = Math.min(min_bridge_length, find_min(i));
        }

        bw.write(String.valueOf(min_bridge_length));
        bw.flush();
    }
}