import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char board[][] = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int count = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i+j)%2 == 0 & board[i][j] == 'F'){
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}