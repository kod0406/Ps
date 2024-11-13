import java.io.*;
import java.util.Arrays;

class Main{
    static int color_paper[][];
    static int white = 0;
    static int blue = 0;

    public static void recursion (int n,int m,int size) throws Exception {
        if(is_color(n,m,size)){
            if(color_paper[n][m] == 1){
                blue++;
            }else{
                white++;
            }
            return;
        }
        int divided_size = size/2;//4분면으로 나누기
        recursion(n,m,divided_size);//1사분면
        recursion(n,m+divided_size,divided_size);//2사분면
        recursion(n+divided_size,m,divided_size);//3사분면
        recursion(n+divided_size,m+divided_size,divided_size);//4사분면
    }

    public static boolean is_color(int row,int col,int size){
        int color = color_paper[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(color_paper[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            color_paper = new int[n][n];
            for(int i=0;i<n;i++){
                String input[] = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    color_paper[i][j] = Integer.parseInt(input[j]);
                }
            }
            recursion(0,0,n);
            bw.write(String.valueOf(white)+"\n");
            bw.write(String.valueOf(blue));
            bw.flush();
    }
}