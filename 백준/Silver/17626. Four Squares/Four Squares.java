import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int dp_table[] = new int[n+1];
        Arrays.fill(dp_table,999);
        dp_table[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp_table[i] = Math.min(dp_table[i],dp_table[i-(j*j)]+1);
            }
        }
        bw.write(String.valueOf(dp_table[n]));
        bw.flush();
    }
}