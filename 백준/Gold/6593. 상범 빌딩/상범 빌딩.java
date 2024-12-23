import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static char[][][] graph;
    static boolean[][][] is_visited;
    static int[] nx = {1, -1, 0, 0, 0, 0};
    static int[] ny = {0, 0, 1, -1, 0, 0};
    static int[] nz = {0, 0, 0, 0, 1, -1};
    static int a, b, c;
    static int start_x, start_y, start_z;

    public static void bfs(int start_z, int start_x, int start_y, BufferedWriter bw) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        is_visited[start_z][start_x][start_y] = true;
        q.offer(new int[]{start_z, start_x, start_y, 0});
        while (!q.isEmpty()) {
            int[] cnt = q.poll();
            int cnt_z = cnt[0];
            int cnt_x = cnt[1];
            int cnt_y = cnt[2];
            int time = cnt[3];
            if (graph[cnt_z][cnt_x][cnt_y] == 'E') {
                bw.write("Escaped in " + time + " minute(s).\n");
                return;
            }
            for (int i = 0; i < 6; i++) {
                int dz = cnt_z + nz[i];
                int dx = cnt_x + nx[i];
                int dy = cnt_y + ny[i];
                if (dz >= 0 && dz < a && dx >= 0 && dx < b && dy >= 0 && dy < c &&
                    (!is_visited[dz][dx][dy]) && graph[dz][dx][dy] != '#') {
                    q.offer(new int[]{dz, dx, dy, time + 1});
                    is_visited[dz][dx][dy] = true;
                }
            }
        }
        bw.write("Trapped!\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);

            if (a == 0 && b == 0 && c == 0) break;

            graph = new char[a][b][c];
            is_visited = new boolean[a][b][c];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    String input_gp = br.readLine();
                    for (int k = 0; k < c; k++) {
                        graph[i][j][k] = input_gp.charAt(k);
                        if (input_gp.charAt(k) == 'S') {
                            start_x = j;
                            start_y = k;
                            start_z = i;
                        }
                    }
                }
                br.readLine();
            }

            bfs(start_z, start_x, start_y, bw);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
