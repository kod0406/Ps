import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] cheese;
    static int[][] airContact;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 처리
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];
        airContact = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int r = 0;

        // 치즈가 모두 녹을 때까지 반복
        while (true) {
            r = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(airContact[i][j] != 0){
                        r++;
                    }
                }
            }
            airContact = new int[N][M];
            visited = new boolean[N][M];

            // BFS로 외부 공기와 접촉 계산
            bfs(0, 0);

            boolean melted = false;

            // 치즈 녹이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cheese[i][j] == 1 && airContact[i][j] >= 1) {
                        cheese[i][j] = 0; // 치즈 녹음
                        melted = true;
                    }
                }
            }

            if (!melted) break; // 더 이상 녹을 치즈가 없으면 종료
            time++;
        }

        // 결과 출력
        bw.write(String.valueOf(time)+"\n"+String.valueOf(r));
        bw.flush();
    }

    // BFS를 통해 외부 공기와의 접촉 계산
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                if (cheese[nx][ny] == 0) { // 공기인 경우
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                } else if (cheese[nx][ny] == 1) { // 치즈인 경우
                    airContact[nx][ny]++;
                }
            }
        }
    }
}
