import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int graph[][];
    public static int rst[][];
    public static boolean is_visited[][][];
    public static int N, M;
    public static int dx[] = {1, -1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};

    public static void bfs() throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0}); // idx 2가 벽을 부순 여부를 관리, 0이 벽을 부수지 않음 1이 벽을 이미 부숨
        is_visited[0][0][0] = true; // 2차원으로 하면 is_visited는 벽을 부쉈는지 안 부쉈는지 모름
        rst[0][0] = 1; // 시작 지점은 1로 설정 (경로 길이 카운팅용)
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int is_break = current[2];
            if (x == M - 1 && y == N - 1) {
                bw.write(String.valueOf(rst[x][y]));
                bw.flush();
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    //1. 벽이 아니고 방문하지 않았을 때
                    if(graph[nx][ny] == 0 && !is_visited[nx][ny][is_break]){
                        q.offer(new int[]{nx, ny, is_break});
                        is_visited[nx][ny][is_break] = true;
                        rst[nx][ny] = rst[x][y] + 1; // 경로 길이를 rst 배열에 업데이트
                    }
                    //2. 벽인데 아직 벽을 부수지 않았고, 벽을 부수고 방문한 적이 없을 때
                    if(graph[nx][ny] == -1 && is_break == 0 && !is_visited[nx][ny][1]){
                        q.offer(new int[]{nx, ny, 1}); // 벽을 부수고 가는 경우
                        is_visited[nx][ny][1] = true; // 벽을 부수고 방문한 적이 있다는 의미
                        rst[nx][ny] = rst[x][y] + 1; // 경로 길이를 rst 배열에 업데이트
                    }
                }
            }
        }
        bw.write("-1");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        graph = new int[M][N];
        rst = new int[M][N];
        is_visited = new boolean[M][N][2]; // 0은 벽을 안 부쉈을 때, 1은 부쉈을 때
        for (int i = 0; i < M; i++) {
            String input_2 = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input_2.charAt(j) == '1') {
                    graph[i][j] = -1; // 벽은 -1로 설정
                }
            }
        }
        bfs();
    }
}