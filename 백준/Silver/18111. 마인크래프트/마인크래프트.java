import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int z = Integer.parseInt(input[1]);
        int inventory = Integer.parseInt(input[2]);
        int coordinate[][] = new int[x][z];
        for(int i=0;i<x;i++){
            String y[] = br.readLine().split(" ");
            for(int j=0;j<z;j++){
                coordinate[i][j] = Integer.parseInt(y[j]);
            }
        }
        int time = Integer.MAX_VALUE;
        int rst_y = 0;
        for(int i=0;i<257;i++){
            int remove_block = 0;
            int add_block = 0;
            int crt_time = 0;
            for(int j=0;j<x;j++){
                for (int k=0;k<z;k++){
                    int layer = coordinate[j][k];
                    if(layer>i){ //블록을 부숴서 평탄화를 할 경우
                        remove_block += layer-i;
                        crt_time += (layer-i)*2;
                    }
                    else{ //블록으로 매꿔서 평탄화를 할 경우
                        add_block += i-layer;
                        crt_time += (i-layer);
                    }
                }
            }
            if(add_block <= inventory+remove_block){
                if(crt_time<time || ((crt_time==time) && (i>rst_y))){
                    time = crt_time;
                    rst_y = i;
                }
            }
        }
        bw.write(String.valueOf(time)+" "+String.valueOf(rst_y));
        bw.flush();
    }
}