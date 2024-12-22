import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    public static int[] nx = {1,-1,0,0};
    public static int[] ny = {0,0,1,-1};
    public static int graph[][];
    public static boolean is_visited[][];
    public static int n;
    public static void bfs(int layer,int x,int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        is_visited[x][y] = true;
        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int cnt_x = cnt[0];
            int cnt_y = cnt[1];
            for(int i=0;i<4;i++){
                int dx = cnt_x+nx[i];
                int dy = cnt_y+ny[i];
                if(dx<n && dx>=0 && dy<n && dy>=0 && !is_visited[dx][dy] && graph[dx][dy]>layer){
                    q.offer(new int[]{dx,dy});
                    is_visited[dx][dy] = true;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        int max = 0;
        //그래프 채워넣기
        for(int i=0;i<n;i++){
            String input[] = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                graph[i][j] = Integer.parseInt(input[j]);
                if(Integer.parseInt(input[j])>max)
                    max = Integer.parseInt(input[j]);
            }
        }
        //침수 bfs
        int area=0;
        for(int i=0;i<=max;i++){
            int max_area = 0;
            is_visited = new boolean[n][n];
            for(int j=0;j<n;j++){
               for (int k=0;k<n;k++){
                   if(!is_visited[j][k] && graph[j][k] > i) {
                       max_area++;
                       bfs(i, j, k);
                   }
               }
            }
           area = Math.max(area,max_area);
        }
        bw.write(String.valueOf(area));
        bw.flush();
    }
}