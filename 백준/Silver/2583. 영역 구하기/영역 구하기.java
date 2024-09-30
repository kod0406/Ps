import java.io.*;
import java.util.*;

class Main{
    public static int graph[][];
    public static boolean is_visited[][];
    public static int M,N,K;
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};

    public static int bfs(int start_x,int start_y){
        int area = 1; // 상하좌우 공간이 막혔을떄를 생각해여 1로 성정
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start_x,start_y});
        is_visited[start_x][start_y] = true;
        while(!q.isEmpty()){
            int crt[] = q.poll();
            int crt_x = crt[0];
            int crt_y = crt[1];
            for(int i=0;i<4;i++){
                int nx = crt_x + dx[i];
                int ny = crt_y + dy[i];
                if(nx>=0 && nx<M && ny>=0 && ny<N && !is_visited[nx][ny] ){
                    q.offer(new int[]{nx,ny});
                    is_visited[nx][ny] = true;
                    area++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inp[] = br.readLine().split(" ");
        M = Integer.parseInt(inp[0]);
        N = Integer.parseInt(inp[1]);
        K = Integer.parseInt(inp[2]);
        graph = new int[M][N];
        is_visited = new boolean[M][N];
        for(int i=0;i<K;i++){
            String input[] = br.readLine().split(" ");
            int s_x = Integer.parseInt(input[0]);
            int s_y = Integer.parseInt(input[1]);
            int e_x = Integer.parseInt(input[2]);
            int e_y = Integer.parseInt(input[3]);
            for(int j=s_x;j<e_x;j++){
                for(int k=s_y;k<e_y;k++){
                    graph[k][j] = 1;
                    is_visited[k][j] = true;
                }
            }
        }
        ArrayList<Integer> rst = new ArrayList<>();
        int cnt = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j] ==0 && !is_visited[i][j]){
                    cnt++;
                    rst.add(bfs(i,j));
                }
            }
        }
        Collections.sort(rst);
        
        bw.write(String.valueOf(cnt));
        bw.newLine();
        for (Integer integer : rst) {
            bw.write(String.valueOf(integer) + " ");
        }
        bw.flush();
    }
}