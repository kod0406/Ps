import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] time = new int[100001];  // 최단 시간을 저장할 배열
    static boolean[] visited = new boolean[100001];  // 방문 여부 체크

    public static void bfs() throws IOException {
        Queue<Integer> tp = new LinkedList<>();  // 순간이동과 걷기를 모두 처리할 큐
        tp.offer(N);  // 시작 위치 수빈이의 위치
        visited[N] = true;  // 시작 위치 방문 표시

        while (!tp.isEmpty()) {
            int crt = tp.poll();

            if (crt == K) {  // 동생을 찾으면
                bw.write(String.valueOf(time[crt]));
                bw.flush();
                return;
            }

            // 순간이동 (2 * crt)
            if (crt * 2 <= 100000 && !visited[crt * 2]) {
                tp.offer(crt * 2);
                time[crt * 2] = time[crt];
                visited[crt * 2] = true;
            }

            // 걷기 (-1)
            if (crt - 1 >= 0 && !visited[crt - 1]) {
                tp.offer(crt - 1);
                time[crt - 1] = time[crt] + 1;
                visited[crt - 1] = true;
            }

            // 걷기 (+1)
            if (crt + 1 <= 100000 && !visited[crt + 1]) {
                tp.offer(crt + 1);
                time[crt + 1] = time[crt] + 1;
                visited[crt + 1] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);  // 수빈이의 위치
        K = Integer.parseInt(input[1]);  // 동생의 위치
        bfs();
    }
}
