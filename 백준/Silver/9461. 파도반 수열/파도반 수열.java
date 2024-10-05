import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        Long dp_table[] = new Long[100];
        dp_table[0] = 1L;
        dp_table[1] = 1L;
        dp_table[2] = 1L;

        for(int i=3;i<100;i++){
            dp_table[i] = dp_table[i-3] + dp_table[i-2];
        }

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp_table[n-1]));
            bw.newLine();
        }
        bw.flush();
    }
}