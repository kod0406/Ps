import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            String input[] = br.readLine().split(" ");
            if(i==0){
                dp[0][0] = Integer.parseInt(input[0]);
            }
            else{
                for(int j=0;j<=i;j++){
                    if(j==0){
                        dp[i][j] = dp[i-1][j] + Integer.parseInt(input[j]);
                    }
                    else if( j == i){
                        dp[i][j] = dp[i-1][j-1] + Integer.parseInt(input[j]);
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + Integer.parseInt(input[j]);
                    }
                }
            }
        }
        bw.write(String.valueOf(Arrays.stream(dp[n-1]).max().getAsInt()));
        bw.flush();
    }
}