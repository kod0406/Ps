import java.io.*;
import java.util.*;

//숨바꼭질과 유사한 문제임
class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int F,S,G,U,D;
    static int graph[]; //시간을 저장할 그래프
    static boolean is_visited[];//방문여부를 저장할 배열

    public static void bfs() throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        graph[S] = 0;
        is_visited[S] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            if(current == G){
                bw.write(String.valueOf(graph[current]));
                bw.flush();
                return;
            }if(current+U <= F && !is_visited[current+U]){
                q.offer(current+U);
                is_visited[current+U] = true;
                graph[current+U] = graph[current]+1;
            }if(current-D >= 1 && !is_visited[current-D]){
                q.offer(current-D);
                is_visited[current-D] = true;
                graph[current-D] = graph[current]+1;
            }
        }
        bw.write("use the stairs");
        bw.flush();
    }
    // F:건물 최대 높이 S:현재 위치 G:목표 위치 U:누르면 설정된 층만큼 상승 D:~~ 하강
    public static void main(String[] args) throws IOException {
        String input[] = br.readLine().split(" ");
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);
        graph = new int[F+1];
        is_visited = new boolean[F+1];
        bfs();
    }
}