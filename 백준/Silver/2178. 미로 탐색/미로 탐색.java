import java.io.*;
import java.util.*;

class Main{
    public static int visited[][];
    public static int graph[][];
    public static int N;
    public static int M;

    public static int dx [] = {-1, 1, 0, 0};
    public static int dy [] = {0, 0, 1, -1};

    public static int bfs(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = 0;
            }
        } // 방문하지 않은 곳은 -1로 초기화
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = 1;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //탐색한 그래프에서 유효범위 내에 있으면 존재하는 그래프에 각각 +1
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == 0 && graph[nx][ny] == 1){
                    visited[nx][ny] = visited[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return visited[N-1][M-1] ;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        graph = new int[N][M];
        visited = new int[N][M];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                graph[i][j] = line.charAt(j) - '0'; // 좌측이 int형 이니까 알아서 int로 형변환됨
            }
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }
}