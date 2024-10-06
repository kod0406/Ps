import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static char graph[][];
    public static boolean is_visited[][];
    public static int N, M;
    public static int dx[] = {1, -1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};

    public static void bfs(int start_x,int start_y) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        int person = 0;
        q.offer(new int[]{start_x,start_y});
        is_visited[start_x][start_y] = true;
        while(!q.isEmpty()){
            int crt[] = q.poll();
            int crt_x = crt[0];
            int crt_y = crt[1];
            for(int i=0;i<4;i++){
                int nx = crt_x + dx[i];
                int ny = crt_y + dy[i];
                if(nx>=0 && ny>=0 && nx<M && ny<N && !is_visited[nx][ny] && graph[nx][ny] !='X'){
                    q.offer(new int[]{nx,ny});
                    is_visited[nx][ny] = true;
                    if(graph[nx][ny] == 'P'){
                        person++;
                    }
                }
            }
        }
        if(person == 0){
            bw.write("TT");
        }else{
            bw.write(String.valueOf(person));
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        graph = new char[M][N];
        is_visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String input_2 = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = input_2.charAt(j);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 'I'){
                    bfs(i,j);
                }
            }
        }
    }
}