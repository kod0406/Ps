import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static int[] time = new int[100001];  // 최단 시간을 저장할 배열
    static boolean[] visited = new boolean[100001];  // 방문 여부 체크

    public static void bfs() throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);  // 시작 위치 수빈이의 위치
        visited[N] = true;  // 시작 위치는 방문

        while (!q.isEmpty()) {
            int current = q.poll();
            if(current == K){
                bw.write(String.valueOf(time[current]));
                bw.flush();
                return;
            }
            if(current-1 >= 0 && !visited[current-1]){// -1 걷기
                q.offer(current-1);
                time[current-1] = time[current]+1;
                visited[current-1] = true;
            }  if (current+1<=100000 && !visited[current+1]) { // +1 걷기
                q.offer(current+1);
                time[current+1] = time[current]+1;
                visited[current+1] = true;
            }  if (current*2 <=100000 && !visited[current*2]) { // *2 순간이동
                q.offer(current*2);
                time[current*2] = time[current]+1;
                visited[current*2] = true;
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