import java.io.*;
import java.util.*;

class Main{
    public static int N,M;
    public static int graph [][];
    public static boolean visited [][];
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};

    public static int bfs(){
        int day = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j] == 1){
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int n[] = q.poll();
            int x = n[0];
            int y = n[1];
            int currentDay = n[2];
            day = Math.max(day,currentDay);
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if( nx>=0 && ny>=0 && nx<N && ny<M && graph[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    graph[nx][ny] = 1;
                    q.offer(new int[]{nx,ny,currentDay+1});
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if (graph[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        // 토마토 상태 입력 받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }
}