import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static char gph[][];
    public static char color_week_gph[][];
    public static boolean is_visited[][];
    public static boolean color_is_visited[][];
    public static int nx[] = {1,-1,0,0};
    public static int ny[] = {0,0,1,-1};
//색약일때와 색약이 아닐때를 각각 처리를 해야함
    //배열을 재활용 하고 싶으니 빨-초를 하나의 char로 변환한다면 해결가능하지 않을까
        //그러면 배추나 그림처럼 쉽게 할 수도 있을것
            //근데 자바는 그런거 없으니까 2개의 그래프를 만드는게 나을것 같음
    public static void bfs(int x,int y,int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        is_visited[x][y] = true;
        while(!q.isEmpty()){
            int crt[]  = q.poll();
            int crt_x = crt[0];
            int crt_y = crt[1];
            for(int i=0;i<4;i++){
                int dx = crt_x + nx[i];
                int dy = crt_y + ny[i];
                if(dx >= 0 && dx<n && dy>=0 && dy<n && !is_visited[dx][dy] && gph[dx][dy] == gph[crt_x][crt_y]){
                    q.offer(new int[]{dx,dy});
                    is_visited[dx][dy] = true;
                }
            }
        }
    }

    public static void color_bfs(int x,int y,int n){
        Queue<int[]> cq = new LinkedList<>();
        cq.add(new int[]{x,y});
        color_is_visited[x][y] = true;
        while(!cq.isEmpty()){
            int crt[]  = cq.poll();
            int crt_x = crt[0];
            int crt_y = crt[1];
            for(int i=0;i<4;i++){
                int dx = crt_x + nx[i];
                int dy = crt_y + ny[i];
                if(dx >= 0 && dx<n && dy>=0 && dy<n && !color_is_visited[dx][dy] && color_week_gph[dx][dy] == color_week_gph[crt_x][crt_y]){
                    cq.offer(new int[]{dx,dy});
                    color_is_visited[dx][dy] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        gph = new char[n][n];
        color_week_gph = new char[n][n];
        is_visited = new boolean[n][n];
        color_is_visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<n;j++){
                gph[i][j] = input.charAt(j);
                if(input.charAt(j)=='G' || input.charAt(j)=='R'){
                    color_week_gph[i][j] = '#';
                }else{
                    color_week_gph[i][j] = input.charAt(j);
                }
            }
        }
        int cnt = 0;
        int week_cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((gph[i][j] == 'R' || gph[i][j] == 'G' || gph[i][j] == 'B') && !is_visited[i][j]){
                    cnt++;
                    bfs(i,j,n);
                }
                if((color_week_gph[i][j] == '#' || color_week_gph[i][j] == 'B') && !color_is_visited[i][j]) {
                    week_cnt++;
                    color_bfs(i, j, n);
                }
            }
        }
        bw.write(String.valueOf(cnt)+" "+String.valueOf(week_cnt));
        bw.flush();
    }
}