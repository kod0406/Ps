import java.io.*;
import java.util.*;

class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N,M;
    public static int burnt_time[][];
    public static int escape_time[][];
    public static char place[][];
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};

    public static void bfs() throws IOException{
        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> jinsu = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(burnt_time[i], -1);
            Arrays.fill(escape_time[i], -1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (place[i][j] == '#') {
                    burnt_time[i][j] = -1;
                    escape_time[i][j] = -1;
                } else if (place[i][j] == 'F') {
                    fire.offer(new int[]{i, j});
                    burnt_time[i][j] = 0;
                } else if (place[i][j] == 'J') {
                    jinsu.offer(new int[]{i, j});
                    escape_time[i][j] = 0;
                }
            }
        }
        while(!fire.isEmpty()){
            int current_1[] = fire.poll();
            int current_1_x = current_1[0];
            int current_1_y = current_1[1];
            for(int i=0;i<4;i++){
                int nx = dx[i] + current_1_x;
                int ny = dy[i] + current_1_y;
                if( nx>=0 && ny>=0 && nx<N && ny<M && burnt_time[nx][ny] == -1 && place[nx][ny] != '#' ){
                    fire.offer(new int[]{nx,ny});
                    burnt_time[nx][ny] = burnt_time[current_1_x][current_1_y]+1;
                }
            }
        }
        while(!jinsu.isEmpty()){
            int current_2[] = jinsu.poll();
            int current_2_x = current_2[0];
            int current_2_y = current_2[1];
            if(current_2_x == 0 || current_2_y==0 || current_2_x == N-1 || current_2_y == M-1){
                bw.write(String.valueOf(escape_time[current_2_x][current_2_y]+1));
                bw.flush();
                return;
            }
            for(int i=0;i<4;i++){
                int nx = dx[i] + current_2_x;
                int ny = dy[i] + current_2_y;
                if (nx>=0 && ny>=0 && nx<N && ny<M && escape_time[nx][ny] == -1 && place[nx][ny] != '#'){
                    if(burnt_time[nx][ny]== -1 || escape_time[current_2_x][current_2_y]+1<burnt_time[nx][ny]){
                        jinsu.offer(new int[]{nx,ny});
                        escape_time[nx][ny] = escape_time[current_2_x][current_2_y]+1;
                    }
                }
            }

        }
        bw.write("IMPOSSIBLE");
        bw.flush();
    }

    public static void main(String[] args) throws IOException{
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        burnt_time = new int[N][M];
        escape_time = new int[N][M];
        place = new char[N][M];
        for(int i=0;i<N;i++){
            String input_line = br.readLine();
            for(int j=0;j<M;j++){
                place[i][j] = input_line.charAt(j);
            }
        }
        bfs();
    }
}