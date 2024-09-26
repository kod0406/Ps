import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int graph[][];
    static boolean is_visited[][];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void bfs(int x,int y){
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{x,y});
        is_visited[x][y] = true;
        while(!q.isEmpty()){
            int current[] = q.poll();
            int current_x = current[0];
            int current_y = current[1];
            for(int i=0;i<4;i++){
                int nx = current_x + dx[i];
                int ny = current_y + dy[i];
                if(nx>=0 && nx< graph.length && ny>=0 && ny< graph[0].length && !is_visited[nx][ny] &&graph[nx][ny]==1){
                    q.offer(new int[]{nx,ny});
                    is_visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int cs = Integer.parseInt(br.readLine());
        int cnt;
        for(int i=0;i<cs;i++){
            cnt = 0;
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph = new int [a][b];
            is_visited = new boolean[a][b];
            for(int j=0;j<c;j++){
                String inp[] = br.readLine().split(" ");
                int x = Integer.parseInt(inp[0]);
                int y = Integer.parseInt(inp[1]);
                graph[x][y] = 1;
            }
            for(int k=0;k<a;k++){
                for(int l=0;l<b;l++){
                    if(graph[k][l] == 1 && !is_visited[k][l]){
                        cnt++;
                        bfs(k,l);
                    }
                }
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
    }
}