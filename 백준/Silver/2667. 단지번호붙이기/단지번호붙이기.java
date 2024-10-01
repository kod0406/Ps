import java.io.*;
import java.util.*;

class Main{
    static boolean is_visited[][];
    static int K;
    static int nx[] = {1,-1,0,0};
    static int ny[] = {0,0,1,-1};
    public static int bfs(int start_x,int start_y){
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start_x,start_y});
        is_visited[start_x][start_y] = true;
        while(!q.isEmpty()){
            int crt[] = q.poll();
            int crt_x = crt[0];
            int crt_y = crt[1];
            for(int i=0;i<4;i++){
                int dx = crt_x + nx[i];
                int dy = crt_y + ny[i];
                if(dx >= 0 && dx<K && dy>=0 && dy<K && !is_visited[dx][dy]){
                    q.offer(new int[]{dx,dy});
                    is_visited[dx][dy] = true;
                    area++;
                }
            }
        }
        return area;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        K = Integer.parseInt(br.readLine());
        is_visited = new boolean [K][K];
        for(int i=0;i<K;i++){
            String input = br.readLine();
            for(int j=0;j<K;j++){
                if(input.charAt(j) == '0'){
                    is_visited[i][j] = true;
                }
            }
        }
        ArrayList<Integer> rst = new ArrayList<>();
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                if(!is_visited[i][j]) {
                    cnt++;
                    rst.add((bfs(i, j)));
                }
            }
        }
        Collections.sort(rst);

        bw.write(String.valueOf(cnt));
        bw.newLine();
        for (Integer integer : rst) {
            bw.write(String.valueOf(integer));
            bw.newLine();

        }
        bw.flush();
    }
}
