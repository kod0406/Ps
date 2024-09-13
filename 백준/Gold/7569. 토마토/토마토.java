import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[][][] graph;
    public static boolean[][][] visited;
    public static int M, N, H;
    public static int dx[] = {1, -1, 0, 0, 0, 0};
    public static int dy[] = {0, 0, 1, -1, 0, 0};
    public static int dz[] = {0, 0, 0, 0, 1, -1};

    public static void bfs() throws IOException {
        int currentDay = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (graph[z][y][x] == 1) {
                        q.offer(new int[]{x, y, z, 0});
                        visited[z][y][x] = true;
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];
            int day = current[3];
            currentDay = Math.max(day, currentDay);
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H && !visited[nz][ny][nx]) {
                    if (graph[nz][ny][nx] == 0) {
                        graph[nz][ny][nx] = 1;
                        q.offer(new int[]{nx, ny, nz, day + 1});
                        visited[nz][ny][nx] = true;
                    }
                }
            }
        }
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (graph[z][y][x] == 0) {
                        bw.write("-1");
                        bw.flush();
                        return;
                    }
                }
            }
        }
        bw.write(String.valueOf(currentDay));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        String[] num = br.readLine().split(" ");
        M = Integer.parseInt(num[0]);
        N = Integer.parseInt(num[1]);
        H = Integer.parseInt(num[2]);
        graph = new int[H][N][M];
        visited = new boolean[H][N][M]; 
        /*for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                String[] input = br.readLine().split(" ");
                for (int x = 0; x < M; x++) {
                    graph[z][y][x] = Integer.parseInt(input[x]);
                }
            }
        }*/
        for(int z=0;z<H;z++){
            for(int y=0;y<N;y++){
                String input[] = br.readLine().split(" ");
                for(int x=0;x<M;x++){
                    graph[z][y][x] = Integer.parseInt(input[x]);
                }
            }
        }
        bfs();
    }
}
